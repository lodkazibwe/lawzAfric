package com.lawyersofafrica.lawyersofafrica.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timeStamp;
    private String message;
    private String details;
}
