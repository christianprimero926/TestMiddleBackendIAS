package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.entry_points;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private HttpStatus status;
    private String message;
}
