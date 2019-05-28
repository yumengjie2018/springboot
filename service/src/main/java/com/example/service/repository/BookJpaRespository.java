package com.example.service.repository;

import com.example.service.entity.response.BookResponse;
import org.springframework.stereotype.Repository;
@Repository
public interface BookJpaRespository {
    BookResponse getBook();
}
