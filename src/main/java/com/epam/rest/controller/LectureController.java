package com.epam.rest.controller;

import com.epam.rest.model.Lecture;
import com.epam.rest.model.Topic;
import com.epam.rest.service.LectureService;
import com.epam.rest.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/lectures")
public class LectureController {

    @Autowired
    protected LectureService lectureService;

    @Autowired
    protected TopicService topicService;

    @ApiOperation(value = "")
    @RequestMapping(method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Lecture>> getLectures(){
        List<Lecture> lectures = lectureService.getLectures();

        if(lectures == null || lectures.isEmpty()){
            return new ResponseEntity<List<Lecture>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "get Lecture by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Lecture> getLectureById(@RequestParam Integer id){
        Lecture lecture = lectureService.getLectureById(id);

        if(lecture == null ){
            return new ResponseEntity<Lecture>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
    }

    @ApiOperation(value = "")
    @RequestMapping(value = "/{id}/topics", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Topic>> getTopicsByLectureId(@RequestParam Integer id){
        Lecture lecture = lectureService.getLectureById(id);

        if(lecture == null || lecture.getTopicList() == null || lecture.getTopicList().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lecture.getTopicList(), HttpStatus.OK);
    }

    @ApiOperation(value = "")
    @RequestMapping(value = "/{id}/topics/{idTopic}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Topic> getTopicById(@RequestParam Integer id,
                                                      @RequestParam Integer idTopic){
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
