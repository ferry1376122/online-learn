package org.online.learn.domain.common;

public enum ReturnCode {
    OPT_SUCESS(0,"SUCESS"),
    OPT_ERROE(1,"ERROR")
    ;
    /** 返回码 */
    private Integer code;
    /** 返回内容详情 */
    private String detail;

    ReturnCode(Integer code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public Integer getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }
}
