package com.yif.community.mapper;

import com.yif.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag)values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create (Question quesion);
}
