package org.online.learn.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "课程信息")
public class Course implements Serializable {
    private static final long serialVersionUID = -1374457079065712144L;
    private Integer id;
    @ApiModelProperty(value = "课程分类", required = false)
    private Integer courseType;
    @ApiModelProperty(value = "课程名称", required = false)
    private String courseName;
    @ApiModelProperty(value = "课程描述", required = false)
    private String courseDesc;
    @ApiModelProperty(value = "老师", required = false)
    private String teacher;
    private Date createTime;
    private Date updateTime;
}
