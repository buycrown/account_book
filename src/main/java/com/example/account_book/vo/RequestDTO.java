package com.example.account_book.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private String date; //일자
    private int amount; //금액
    private String location; //입출금처
    private String note; //적요
    private String searchDate; //검색월
}
