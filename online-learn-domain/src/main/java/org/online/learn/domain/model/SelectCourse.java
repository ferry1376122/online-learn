package org.online.learn.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "选课信息")
public class SelectCourse implements Serializable {
    private static final long serialVersionUID = -1374457079065712144L;
    private Integer id;
    @ApiModelProperty(value = "用户id", required = false)
    private Integer userId;
    @ApiModelProperty(value = "课程id", required = false)
    private String courseId;
    private Date createTime;
    private Date updateTime;
}
