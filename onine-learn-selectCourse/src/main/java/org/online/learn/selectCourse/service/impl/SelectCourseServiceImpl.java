package org.online.learn.selectCourse.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.online.learn.domain.model.SelectCourse;
import org.online.learn.domain.model.SelectCourseInfo;
import org.online.learn.selectCourse.dao.SelectCourseDao;
import org.online.learn.selectCourse.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("selectCourseService")
public class SelectCourseServiceImpl implements SelectCourseService {
    @Autowired
    private SelectCourseDao selectCourseDao;

    @Override
    public int addMyCourse(SelectCourse selectCourse) {
        return selectCourseDao.saveMyCourse(selectCourse);
    }

    @Override
    public List<SelectCourseInfo> querySelectCourse(Integer userId, Integer courseId) {
        return selectCourseDao.querySelectCourse(userId,courseId);
    }


}
