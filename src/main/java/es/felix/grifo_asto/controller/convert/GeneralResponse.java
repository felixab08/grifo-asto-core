package es.felix.grifo_asto.controller.convert;

import lombok.Data;

@Data
public class GeneralResponse <T>{
    private int code;
    private String message;
    private T data;
}
