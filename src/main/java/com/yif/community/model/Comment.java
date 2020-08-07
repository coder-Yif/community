package com.yif.community.model;

import lombok.Data;

@Data
public class Comment {
    private long id;
    private long parentId;
    private String content;
    private Integer type;
    private Integer commentator;
    private Integer likeCount;
    private Long gmtCreate;
    private Long gmtModified;
}
