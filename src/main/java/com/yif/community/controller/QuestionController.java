package com.yif.community.controller;

import com.yif.community.dto.QuestionDTO;
import com.yif.community.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model){
        questionService.incView(id);
        QuestionDTO questionDTO=questionService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
