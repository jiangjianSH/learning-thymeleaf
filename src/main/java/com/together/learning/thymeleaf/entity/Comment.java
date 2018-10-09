package com.together.learning.thymeleaf.entity;

/**
 * @author jiangjian
 */
public class Comment {
    private Integer id;

    private String text;

    public Comment(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
