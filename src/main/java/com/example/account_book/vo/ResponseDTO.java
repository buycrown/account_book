package com.example.account_book.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {

    private boolean result;
    private String resultMessage;
    private List<RequestDTO> list;
}
