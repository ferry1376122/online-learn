package org.online.learn.selectCourse.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.online.learn.domain.common.Callback;
import org.online.learn.domain.common.ReturnCode;
import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.SelectCourse;
import org.online.learn.domain.model.SelectCourseInfo;
import org.online.learn.domain.model.User;
import org.online.learn.selectCourse.feign.CourseFeignInterface;
import org.online.learn.selectCourse.feign.UserFeignInterface;
import org.online.learn.selectCourse.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/selectCourse")
@Api(value = "SelectCourseController", tags = "选课API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SelectCourseController {

    @Autowired
    private SelectCourseService selectCourseService;
    @Autowired
    private UserFeignInterface userFeignInterface;
    @Autowired
    private CourseFeignInterface courseFeignInterface;

    @RequestMapping(value="/addMyCourse",method = RequestMethod.POST)
    @ApiOperation(value = "新增选课", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<SelectCourse> addMyCourse(SelectCourse selectCourse){
        if(selectCourse.getId()!=null){
            selectCourse.setId(null);
        }
        if(selectCourse.getCreateTime()==null){
            selectCourse.setCreateTime(new Date());
        }
        if(selectCourse.getUpdateTime()==null){
            selectCourse.setUpdateTime(new Date());
        }
        int i=selectCourseService.addMyCourse(selectCourse);
        if(i>0) {
            log.info("SelectCourse id:" + selectCourse.getId());
            return new Callback<SelectCourse>(ReturnCode.OPT_SUCESS, selectCourse, true);
        }else{
            return new Callback<SelectCourse>(ReturnCode.OPT_ERROE, null, false);
        }
    }

    @RequestMapping(value="/queryMyCourseList",method = RequestMethod.POST)
    @ApiOperation(value = "选课列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<List<SelectCourseInfo>> queryMyCourseList(@RequestParam(value = "userId",required = false) Integer userId,@RequestParam(value = "courseId",required = false) Integer courseId){
        log.info("userId:"+userId);
        log.info("courseId:"+courseId);
        List<SelectCourseInfo> list=null;
        try{
            list=selectCourseService.querySelectCourse(userId,courseId);
            log.info("list.size"+list.size());
            Map<Integer, Map<String, Object>> userMap=null;
            Map<Integer, Map<String, Object>> courseMap=null;
            if(list.size()>0){
                Set<Integer> userIds=new HashSet<Integer>();
                Set<Integer> courseIds=new HashSet<Integer>();
                for(SelectCourseInfo selectCourseInfo:list){
                    userIds.add(selectCourseInfo.getUserId());
                    courseIds.add(selectCourseInfo.getCourseId());
                }
                if(userIds.size()>0){
                    log.info("userFeignInterface start");
                    Callback<Map<Integer, Map<String, Object>>> result=userFeignInterface.getUserInfo(userIds);
                    log.info("userFeignInterface end");
                    if(result.getDatas().size()>0){
                        userMap=result.getDatas();
                    }
                }
                if(courseIds.size()>0){
                    log.info("courseFeignInterface start");
                    Callback<Map<Integer, Map<String, Object>>> result=courseFeignInterface.getCourseInfo(courseIds);
                    log.info("courseFeignInterface end");
                    if(result.getDatas().size()>0){
                        courseMap=result.getDatas();
                    }
                }
            }
            for(SelectCourseInfo selectCourseInfo:list){
                if(userMap!=null){
                    Integer userId1=selectCourseInfo.getUserId();
                    log.info("userId1 :"+userId1);
                    Map<String, Object> usermap1=userMap.get(userId1);
                    String userName=(String) usermap1.get("user_name");
                    log.info("userName :"+userName);
                    selectCourseInfo.setUserName(userName);
                }
                if(courseMap!=null){
                    Integer courseId1=selectCourseInfo.getCourseId();
                    log.info("courseId1 :"+courseId1);
                    Map<String, Object> coursemap1=courseMap.get(courseId1);
                    String courseName=(String) coursemap1.get("course_name");
                    log.info("courseName :"+courseName);
                    String teacher=(String) coursemap1.get("teacher");
                    log.info("teacher :"+teacher);
                    selectCourseInfo.setCourseName(courseName);
                    selectCourseInfo.setTeacher(teacher);
                }
            }
            return new Callback<List<SelectCourseInfo>>(ReturnCode.OPT_SUCESS, list, true);
        }catch (Exception e){
            log.error(e.getMessage());
            return new Callback<List<SelectCourseInfo>>(ReturnCode.OPT_ERROE, null, false);
        }
    }
}
