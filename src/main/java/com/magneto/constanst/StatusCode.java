package com.magneto.constanst;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
	
    OK(0, "ok"), INTERNAL_SERVER_ERROR(-1, "internal server error"), NOT_FOUND(-2, "DNA not found"),
    BAD_REQUEST(-3, "Bad Request");

    private Integer code;
    private String description;
}
