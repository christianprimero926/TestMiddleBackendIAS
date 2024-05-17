package com.example.testbackend.domain;

import java.util.List;

public interface IServicesService {
    PaginatorDto<Services> getall(int page, int size);
}
