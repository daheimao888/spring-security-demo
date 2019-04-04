package com.meek.demo.dto;

import lombok.Data;

/**
 * Created by ace on 2017/8/23.
 */
@Data
public class BaseResponse {
    private int status = 20000;
    private String msg = "操作成功";
    private String refreshToken;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.msg = message;
    }

    public BaseResponse() {
    }


}
