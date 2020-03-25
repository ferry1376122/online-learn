package org.online.learn.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.online.learn.course.service.CourseService;
import org.online.learn.domain.common.Callback;
import org.online.learn.domain.common.ReturnCode;
import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/course")
@Api(value = "CourseController", tags = "课程API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/addCourse",method = RequestMethod.POST)
    @ApiOperation(value = "新增课程", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<Course> addCourse(@RequestBody Course course){
        if(course.getId()!=null){
            course.setId(null);
        }
        if(course.getCreateTime()==null){
            course.setCreateTime(new Date());
        }
        if(course.getUpdateTime()==null){
            course.setUpdateTime(new Date());
        }
        int i=courseService.addCourse(course);
        if(i>0) {
            log.info("course id:" + course.getId());
            return new Callback<Course>(ReturnCode.OPT_SUCESS, course, true);
        }else{
            return new Callback<Course>(ReturnCode.OPT_ERROE, null, false);
        }
    }

    @RequestMapping(value="/getCourseInfo",method = RequestMethod.POST)
    @ApiOperation(value = "查询课程信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<Map<Integer, Map<String, Object>>> getCourseInfo(@RequestBody HashSet<Integer> courseids){
        Map<Integer, Map<String, Object>> map;
        try{
            log.info("courseids"+courseids.size());
            map=courseService.getCourseInfo(courseids);
            log.info("map"+map.size());
            return new Callback<Map<Integer, Map<String, Object>>>(ReturnCode.OPT_SUCESS, map, true);
        }catch (Exception e){
            return new Callback<Map<Integer, Map<String, Object>>>(ReturnCode.OPT_ERROE, null, false);
        }
    }
}
