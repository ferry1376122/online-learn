package org.online.learn.course.service;

import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CourseService {
    int addCourse(Course course);
    Map<Integer, Map<String, Object>> getCourseInfo(Set courseids);
}
