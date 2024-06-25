package cn.edu.zust.se.enums;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ShenYi
 * @Date: 2024-06-14-17:27
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum UserTypeEnum {

    MEMBER(1, "会员"),//普通用户
    ADMIN(2, "管理员");//管理员

    /**
     * 类型
     */
    private final Integer value;

    /**
     * 类型名
     */
    private final String name;

    public static UserTypeEnum valueOf(Integer value){
        return ArrayUtil.firstMatch(userType -> userType.getValue().equals(value), UserTypeEnum.values());
    }

}
