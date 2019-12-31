package com.example.service.service.impl;

import com.example.service.entity.response.BookResponse;
import com.example.service.mapper.BookJpaRespository;
import com.example.service.service.BookJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * title：BookJpaServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/2/18 9:29
 */
@Service
public class BookJpaServiceImpl implements BookJpaService {

    @Autowired
    private BookJpaRespository respository;

    @Override
    public BookResponse getBook() {

        BookResponse bookResponse=respository.getBook();
        if(bookResponse==null){
            return new BookResponse();
        }
        return bookResponse;
    }
}