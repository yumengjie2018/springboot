package com.example.service.mapper;

import com.example.service.entity.response.BookResponse;
import org.springframework.stereotype.Repository;
@Repository
public interface BookJpaRespository {
    BookResponse getBook();
}
