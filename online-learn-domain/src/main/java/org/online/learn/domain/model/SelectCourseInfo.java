package org.online.learn.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelectCourseInfo implements Serializable {

    private static final long serialVersionUID = -4297758091690194855L;
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer courseId;
    private String courseName;
    private String teacher;
    private Date createTime;
    private Date updateTime;
}
