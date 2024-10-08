package com.example.capstone.controller;

import com.example.capstone.dto.MemberDTO;
import com.example.capstone.dto.TodoDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.capstone.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;

    @GetMapping("/main")
    public String main(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginEmail = (MemberDTO) session.getAttribute("loginMember");
        model.addAttribute("member", loginEmail);
        return "main"; // 메인 페이지로 이동
    }

//  @PostMapping("/main")
//  public String login(@ModelAttribute TodoDTO todoDTO, HttpSession session, Model model) {
//
//        return ;
//    }




}
