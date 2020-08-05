package com.yif.community.mapper;

import com.yif.community.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionExtMapper {
    int incView(Question question);
}