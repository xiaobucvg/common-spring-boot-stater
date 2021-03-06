package site.xiaobu.starter.common.base.wrapper;

import lombok.Data;
import site.xiaobu.starter.common.base.IResponse;

/**
 * 业务失败包装类
 * code 业务失败状态码
 * message 业务失败描述信息
 * origin 原始业务失败对象
 */
@Data
public class FailedWrapper<T> implements IResponse {
    private int code;
    private String message;
    private T origin;

    private FailedWrapper(int code, String message, T origin) {
        this.code = code;
        this.message = message;
        this.origin = origin;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public static <T> FailedWrapper wrap(int code, String message, T data) {
        return new FailedWrapper<>(code, message, data);
    }
}
