package org.online.learn.course.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.online.learn.course.dao.CourseDao;
import org.online.learn.course.service.CourseService;
import org.online.learn.domain.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public int addCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Map<Integer, Map<String, Object>> getCourseInfo(Set courseids) {
        log.info("CourseServiceImpl getCourseInfo");
        return courseDao.getCourseInfo(courseids);
    }

}
