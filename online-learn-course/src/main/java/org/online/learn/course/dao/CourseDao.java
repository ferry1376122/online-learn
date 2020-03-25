package org.online.learn.course.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface CourseDao {
    int saveCourse(Course course);
    @MapKey("id")
    Map<Integer, Map<String, Object>> getCourseInfo(@Param("courseids") Set courseids);
}
