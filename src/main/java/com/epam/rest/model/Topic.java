package com.epam.rest.model;

public class Topic {
    private Integer id;
    private String title;
    private Integer lectureID;

    public Topic() {
    }

    public Topic(int id, String title, int lectureID) {
        this.id = id;
        this.title = title;
        this.lectureID = lectureID;
    }

    public Integer getLectureID() {
        return lectureID;
    }

    public void setLectureID(Integer lectureID) {
        this.lectureID = lectureID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
