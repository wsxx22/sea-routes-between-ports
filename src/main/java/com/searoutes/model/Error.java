package com.searoutes.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Error {

    private int code;
    private String userMessage;
}
