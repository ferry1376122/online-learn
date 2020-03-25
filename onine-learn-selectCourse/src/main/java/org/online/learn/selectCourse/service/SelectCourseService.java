package org.online.learn.selectCourse.service;

import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.SelectCourse;
import org.online.learn.domain.model.SelectCourseInfo;

import java.util.List;

public interface SelectCourseService {
    int addMyCourse(SelectCourse selectCourse);
    List<SelectCourseInfo> querySelectCourse(Integer userId, Integer courseId);
}
