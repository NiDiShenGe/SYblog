package cn.edu.zust.se.pojo;

import cn.edu.zust.se.exception.ErrorCode;
import cn.edu.zust.se.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @Author: ShenYi
 * @Date: 2024-06-13-14:22
 * @Description:
 * 通用返回
 *
 * @Param <T> 数据泛型
 */

@Data
public class CommonResult<T> implements Serializable {
    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg() ()
     */
    private String msg;

    public static <T> CommonResult<T> error(CommonResult<?> result) {
        return error(result.getCode(), result.getMsg());
    }
    public static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }
}
