package com.epam.rest.service;

import com.epam.rest.model.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> getLectures();

    Lecture getLectureById(Integer id);

    Lecture getLectureByTitle(String title);

}
