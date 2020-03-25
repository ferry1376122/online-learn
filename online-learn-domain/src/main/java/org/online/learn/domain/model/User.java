package org.online.learn.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用户信息")
public class User implements Serializable {
    private static final long serialVersionUID = -1374457079065712144L;
    private Integer id;
    @ApiModelProperty(value = "用户名", required = false)
    private String userName;
    @ApiModelProperty(value = "密码", required = false)
    private String passWord;
    @ApiModelProperty(value = "邮件", required = false)
    private String email;
    @ApiModelProperty(value = "手机号", required = false)
    private String phone;
    @ApiModelProperty(value = "地址", required = false)
    private String address;
    @ApiModelProperty(value = "爱好", required = false)
    private String hobby;
    private Date createTime;
    private Date updateTime;
}
