package org.online.learn.selectCourse.dao;

import org.apache.ibatis.annotations.Param;
import org.online.learn.domain.model.Course;
import org.online.learn.domain.model.SelectCourse;
import org.online.learn.domain.model.SelectCourseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectCourseDao {
    int saveMyCourse(SelectCourse selectCourse);
    List<SelectCourseInfo>  querySelectCourse(@Param("userId") Integer userId, @Param("courseId") Integer courseId);
}
