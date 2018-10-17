package com.epam.rest.service;

import com.epam.rest.model.Lecture;
import com.epam.rest.model.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getTopics();

    List<Topic> getTopicsByLecture(Lecture lecture);

    Topic getTopicByTitle(String title);

    Topic getTopicById(Lecture lecture, Integer id);
}
