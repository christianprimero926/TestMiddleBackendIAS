package com.example.testbackend.domain;

import java.util.List;

public class PaginatorDto<T> {
    private List<T> data;
    private int totalPages;
    private int totalElements;
}
