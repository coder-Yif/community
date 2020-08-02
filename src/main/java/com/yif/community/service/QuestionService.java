package com.yif.community.service;

import com.yif.community.dto.QuestionDTO;
import com.yif.community.mapper.QuestionMapper;
import com.yif.community.mapper.UserMapper;
import com.yif.community.model.Question;
import com.yif.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.yif.community.dto.PaginationDTO;
@Component
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public PaginationDTO list(Integer page,Integer size){

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        if(page<1){
            page=1;
        }
        if(page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }
        Integer offset=size * (page-1);
        List<Question> questions=questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question=questionMapper.getById(id);
        QuestionDTO questionDTO=new QuestionDTO();
        User user=userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        BeanUtils.copyProperties(question,questionDTO);
        return questionDTO;
    }
}
