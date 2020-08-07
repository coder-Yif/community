package com.yif.community.mapper;

import com.yif.community.model.Comment;
import com.yif.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {
    @Insert("insert into comment(id,parent_id,type,commentator,gmt_create,gmt_modified,content,like_count)values" +
            "(#{id},#{parentId},#{type},#{commentator},#{gmtCreate},#{gmtModified},#{content},#{likeCount})")
    void insert (Comment comment);
    @Select("select * from comment where parent_id=#{parentId}")
    Comment selectByPrimaryKey(long parentId);

}
