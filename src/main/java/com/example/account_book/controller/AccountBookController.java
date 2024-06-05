package com.example.account_book.controller;

import com.example.account_book.service.AccountBookService;
import com.example.account_book.vo.RequestDTO;
import com.example.account_book.vo.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountBookController {

    private final AccountBookService accountBookService;

    @GetMapping(value = "/home")
    public ModelAndView goHome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    // 지출/수입 입력
    @PostMapping(value = "/insert", produces = "application/json;charset=UTF-8")
    public ModelAndView inputBook(@RequestParam String targetDate, @RequestParam int targetMoney,
                                  @RequestParam String targetAccount, @RequestParam String targetText) {
        ResponseDTO responseDTO = new ResponseDTO();
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setDate(targetDate);
        requestDTO.setAmount(targetMoney);
        requestDTO.setLocation(targetAccount);
        requestDTO.setNote(targetText);
        accountBookService.inputBook(requestDTO, responseDTO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("result", responseDTO.getResultMessage());
        mav.setViewName("home");
        return mav;
    }


    // 지출내역 조회
    @GetMapping(value = "/find" ,produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> findBook(@RequestParam String targetMonth) {
        ResponseDTO responseDTO = new ResponseDTO();
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setSearchDate(targetMonth);
        accountBookService.findBook(requestDTO, responseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
