package com.meek.demo.dto.constant;

public enum CodeStatus {

    //成功
    CODE_SUCCESS(20000, "请求成功"),


    /**
     * 服务错误,10***
     * 服务器内部错误(自定义的异常)
     */

    SERVICE_UNKNOWNERROR(10000, "未知原因"),
    SERVICE_UNAVAILABLE(10001, "服务不可用"),
    SERVICE_INTERNELEXCEPTION(10002, "服务内部异常"),
    SERVICE_TOOBUSY(10003, "服务繁忙"),
    SERVICE_TIMEOUT(10004, "服务超时"),
    SERVICE_NOTFOUND(10005, "服务不存在"),
    SERVICE_UNSUPPORTCALL(10006, "不支持的调用方式,请参考API文档"),
    SERVICE_DEPRECATED(10007, "服务已弃用"),

    /**
     * 参数错误,11***
     * 请求参数错误（对GET和POST请求中携带的参数的校验结果）
     */

    //API文档相关,110**
    PARAM_ERROR(11000, "请参考API文档"),
    PARAM_INVALID(11001, "非法参数(),请参考API文档"),
    PARAM_UNSUPPORTMEDIATYPE(11002, "不支持的MEDIATYPE(%S)"),
    PARAM_INVALIDFORMAT(11003, "无效数据格式,请参考API文档"),
    PARAM_INVALIDENCODE(11004, "编码错误,请参考API文档"),
    PARAM_FILEERROR(11005, "暂不支持该格式的文件上传,请您重新上传"),

    //缺少参数,111**
    PARAM_NEEDAPPKEY(11100, "缺少APPKEY"),
    PARAM_NEEDAPIKEY(11101, "缺少APIKEY"),
    PARAM_NEEDSIGN(11102, "缺少SIGN"),
    PARAM_NEEDTIMESTAMP(11103, "缺少时间戳TIMESTAMP"),
    PARAM_REQUIRED_MISS(11104, "缺少必选参数,请参考API文档"),
    PARAM_REQUIRED_FAILURE(11104, "token缺失或失效"),
    PARAM_ACCESS_FORBIDDEN(11105, "权限等级不够"),
    RESULT_FAILED(11106, "系统内部异常"),

    ;

    private int value;
    private String name;

    CodeStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    /**
     * @param code 状态码
     * @return 状态枚举
     * @desc 通过状态码查询状态枚举
     */
    public static CodeStatus getEnum(int code) {
        if (code == 0) {
            return null;
        }
        for (CodeStatus codeStatus : CodeStatus.values()) {
            if (codeStatus.getValue() == code) {
                return codeStatus;
            }
        }
        return null;
    }
}
