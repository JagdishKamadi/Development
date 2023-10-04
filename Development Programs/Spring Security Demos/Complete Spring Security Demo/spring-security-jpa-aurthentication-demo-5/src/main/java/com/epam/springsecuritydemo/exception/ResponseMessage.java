package com.epam.springsecuritydemo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseMessage {
    private String error;
    private String path;
    private String timestamp;
    private String status;
}
