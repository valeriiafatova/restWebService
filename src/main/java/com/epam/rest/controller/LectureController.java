package com.epam.rest.controller;

import com.epam.rest.model.Lecture;
import com.epam.rest.model.Topic;
import com.epam.rest.service.LectureService;
import com.epam.rest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {

    @Autowired
    protected LectureService lectureService;

    @Autowired
    protected TopicService topicService;

    @RequestMapping(value = "/lectures", method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Lecture>> getLecture(){
        List<Lecture> lectures = lectureService.getLectures();

        if(lectures == null || lectures.isEmpty()){
            return new ResponseEntity<List<Lecture>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
    }
    @RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Lecture> getLectureByID(@PathVariable("id") Integer id){
        Lecture lecture = lectureService.getLectureById(id);

        if(lecture == null ){
            return new ResponseEntity<Lecture>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
    }

    @RequestMapping(value = "/lecture/{id}/topics", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Topic>> getTopicsByLectureId(@PathVariable("id") Integer id){
        Lecture lecture = lectureService.getLectureById(id);

        if(lecture == null || lecture.getTopicList() == null || lecture.getTopicList().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lecture.getTopicList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/lecture/{id}/topic/{idTopic}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Topic> getTopicByLectureIdAndTopicId(@PathVariable("id") Integer id,
                                                      @PathVariable ("idTopic" )Integer idTopic){
        Lecture lecture = lectureService.getLectureById(id);

        Topic topic = null;
        if(lecture != null) {
            topic = topicService.getTopicById(lecture, idTopic);
        }

        if(topic == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }


}
