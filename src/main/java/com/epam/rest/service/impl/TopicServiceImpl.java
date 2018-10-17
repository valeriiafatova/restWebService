package com.epam.rest.service.impl;

import com.epam.rest.model.Lecture;
import com.epam.rest.model.Topic;
import com.epam.rest.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private List<Topic> topics;

    public TopicServiceImpl() {
        topics = new ArrayList<>();
        topics.add(new Topic(1, "Rest", 1));
        topics.add(new Topic(2, "Soap", 1));
        topics.add(new Topic(1, "TDD", 2));
        topics.add(new Topic(2, "JUnit", 2));
        topics.add(new Topic(3, "Mockito", 2));
    }

    @Override
    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public List<Topic> getTopicsByLecture(Lecture lecture) {
        List<Topic> lectureTopics = new ArrayList();
        for(Topic topic: topics){
            if(lecture.getId().equals(topic.getLectureID())){
                lectureTopics.add(topic);
            }
        }
        return lectureTopics;
    }

    @Override
    public Topic getTopicByTitle(String title) {
        for(Topic topic: topics){
            if(topic.getTitle().equals(title)){
                return topic;
            }
        }
        return null;
    }

    @Override
    public Topic getTopicById(Lecture lecture, Integer id) {
        List<Topic> topics = getTopicsByLecture(lecture);
        for(Topic topic: topics){
            if(topic.getId().equals(id)){
                return topic;
            }
        }
        return null;
    }
}
