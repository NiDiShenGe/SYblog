package cn.edu.zust.se.exception;

import lombok.Data;

/**
 * @Author: ShenYi
 * @Date: 2024-06-13-14:33
 * @Description:
 */
@Data
public class ErrorCode {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
