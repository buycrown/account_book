package com.example.account_book.service;

import com.example.account_book.repository.AccountBookRepository;
import com.example.account_book.vo.RequestDTO;
import com.example.account_book.vo.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountBookService {

    private final AccountBookRepository accountBookRepository;
    public void inputBook(RequestDTO requestDTO, ResponseDTO responseDTO) {
        accountBookRepository.insertBook(requestDTO);
        responseDTO.setResult(true);
    }

    public void findBook(RequestDTO requestDTO, ResponseDTO responseDTO) {
        List<RequestDTO> dtoList =  accountBookRepository.selectBook(
                requestDTO.getSearchDate().replaceAll("-","").substring(0,6));
        responseDTO.setResult(true);
        responseDTO.setList(dtoList);
    }
}
