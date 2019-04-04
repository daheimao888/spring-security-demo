package com.meek.demo.dto;


import com.meek.demo.dto.constant.CodeStatus;

/**
 * Created by Ace on 2017/6/11.
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse() {
        data = (T) new Object();
    }

    public ObjectRestResponse(T data) {
        this.data = data;
    }

    public ObjectRestResponse(CodeStatus codeStatus) {
        super(codeStatus.getValue(),codeStatus.getName());
        this.data = (T) new Object();
    }

    public ObjectRestResponse(int status, String msg) {
        super(status,msg); status = status;
        this.data = (T) new Object();
    }
    public ObjectRestResponse(int status, String msg, T data) {
        super(status,msg); status = status;
        this.data = data;
    }

    public ObjectRestResponse rel(boolean rel) {
        return this;
    }

    public ObjectRestResponse data(T data) {
        if(null == data || "".equals(data)){
            data = (T) new Object();
        }else {
            this.setData(data);
        }

        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ObjectRestResponse getResultException(Object data){
        return new ObjectRestResponse(CodeStatus.SERVICE_INTERNELEXCEPTION.getValue(),
                CodeStatus.SERVICE_INTERNELEXCEPTION.getName(),data);
    }

    public static ObjectRestResponse getResultSuccess(Object data){
        return new ObjectRestResponse(CodeStatus.CODE_SUCCESS.getValue(),
                CodeStatus.CODE_SUCCESS.getName(),data);
    }

    public static ObjectRestResponse getResultFailed(Object data){
        return new ObjectRestResponse(CodeStatus.RESULT_FAILED.getValue(),
                CodeStatus.RESULT_FAILED.getName(),data);
    }




}
