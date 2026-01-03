package es.felix.grifo_asto.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Generic pagination response wrapper.
 * Provides a clean, consistent structure for paginated API responses.
 *
 * @param <T> The type of data being paginated
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse<T> {

    @JsonProperty("content")
    private List<T> content;

    @JsonProperty("page")
    private int page;

    @JsonProperty("size")
    private int size;

    @JsonProperty("totalElements")
    private long totalElements;

    @JsonProperty("totalPages")
    private int totalPages;

    @JsonProperty("first")
    private boolean first;

    @JsonProperty("last")
    private boolean last;

    @JsonProperty("hasNext")
    private boolean hasNext;

    @JsonProperty("hasPrevious")
    private boolean hasPrevious;

    @JsonProperty("numberOfElements")
    private int numberOfElements;

    @JsonProperty("empty")
    private boolean empty;

    /**
     * Create a PaginationResponse from a Spring Data Page.
     *
     * @param page Spring Data Page object
     * @param <T>  Type of content
     * @return PaginationResponse instance
     */
    public static <T> PaginationResponse<T> fromPage(Page<T> page) {
        return PaginationResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .build();
    }

    /**
     * Create a PaginationResponse by mapping the content of a Spring Data Page.
     * Useful when you need to convert the Page content to a different type (e.g., Entity to DTO).
     *
     * @param page    Spring Data Page object
     * @param content Mapped content list
     * @param <T>     Type of mapped content
     * @return PaginationResponse instance
     */
    public static <T> PaginationResponse<T> fromPage(Page<?> page, List<T> content) {
        return PaginationResponse.<T>builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .build();
    }
}
