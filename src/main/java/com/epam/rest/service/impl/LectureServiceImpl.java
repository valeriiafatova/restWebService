package com.epam.rest.service.impl;

import com.epam.rest.model.Lecture;
import com.epam.rest.service.LectureService;
import com.epam.rest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LectureServiceImpl implements LectureService {

    private List<Lecture> lectures;

    @Autowired
    private TopicService topicService;

    public LectureServiceImpl() {
        lectures = new ArrayList<>();
        lectures.add(new Lecture(1, "WebServices" ));
        lectures.add(new Lecture(2, "Testing"));
    }

    @Override
    public List<Lecture> getLectures() {
        for(Lecture lecture: lectures){
            lecture.setTopicList(topicService.getTopicsByLecture(lecture));
        }
        return lectures;
    }

    @Override
    public Lecture getLectureById(Integer id) {
        for(Lecture lecture: lectures){
            if(lecture.getId().equals(id)){
                lecture.setTopicList(topicService.getTopicsByLecture(lecture));
                return lecture;
            }
        }
        return null;
    }

    @Override
    public Lecture getLectureByTitle(String title) {
        for(Lecture lecture: lectures){
            if(lecture.getTitle().equals(title)){
                lecture.setTopicList(topicService.getTopicsByLecture(lecture));
                return lecture;
            }
        }
        return null;
    }
}
