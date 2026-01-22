package es.felix.grifo_asto.shared;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Standard pagination request DTO.
 * Provides clean, validated pagination parameters with sensible defaults.
 */
@Data
@Builder
public class PaginationRequest {

 
    @Min(value = 0, message = "Page number must be 0 or greater")
    @Max(value = 10000, message = "Page number must not exceed 10000")
    @Builder.Default
    private Integer page = 0;


    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size must not exceed 100")
    @Builder.Default
    private Integer size = 20;


    @Builder.Default
    private String sort = "createdAt,desc";

    /**
     * Constructor that ensures default values are always set.
     * Used by Spring when binding query parameters.
     */
    public PaginationRequest() {
        this.page = 0;
        this.size = 20;
        this.sort = "createdAt,desc";
    }

    /**
     * Full constructor for manual instantiation.
     */
    public PaginationRequest(Integer page, Integer size, String sort) {
        this.page = page != null ? page : 0;
        this.size = size != null ? size : 20;
        this.sort = sort != null && !sort.isBlank() ? sort : "createdAt,desc";
    }

    /**
     * Convert this request to Spring Data Pageable.
     * Parses sort string and creates appropriate Pageable instance.
     */
    public Pageable toPageable() {
        if (sort == null || sort.isBlank()) {
            return PageRequest.of(page, size);
        }

        // Parse sort string (format: "field,direction" or just "field")
        String[] sortParts = sort.split(",");
        String field = sortParts[0].trim();

        Sort.Direction direction = Sort.Direction.ASC;
        if (sortParts.length > 1) {
            String directionStr = sortParts[1].trim().toLowerCase();
            direction = directionStr.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        return PageRequest.of(page, size, Sort.by(direction, field));
    }

    /**
     * Convert this request to Spring Data Pageable with a default sort.
     * Use this when you want to provide a fallback sort if none is specified.
     */
    public Pageable toPageable(Sort defaultSort) {
        if (sort == null || sort.isBlank()) {
            return PageRequest.of(page, size, defaultSort);
        }
        return toPageable();
    }
}
