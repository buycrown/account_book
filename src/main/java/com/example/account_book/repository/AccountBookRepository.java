package com.example.account_book.repository;

import com.example.account_book.vo.RequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountBookRepository {
    void insertBook(RequestDTO requestDTO);

    List<RequestDTO> selectBook(String searchDate);
}
