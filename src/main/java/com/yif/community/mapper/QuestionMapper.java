package com.yif.community.mapper;

import com.yif.community.model.Question;
import com.yif.community.model.User;
import org.apache.ibatis.annotations.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Component
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag)values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create (Question question);
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question")
    Integer count();
    @Select("select * from question where id = #{id}")
    Question getById(@Param("id") Integer id);
    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    void update(Question question);
    @Update("update question set view_count=view_count+#{viewCount} where id=#{id}")
    void incView(Question question);
}