package cn.edu.zust.se.core.enums;

import cn.edu.zust.se.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: ShenYi
 * @Date: 2024-07-09-9:45
 * @Description:
 * 区域类型枚举
 */
@Getter
@AllArgsConstructor
public enum AreaEnum implements IntArrayValuable {
    COUNTRY(1,"国家"),
    PROVINCE(2,"省份"),
    CITY(3,"城市"),
    DISTRICT(4,"地区");

    public static final int [] ARRAY = Arrays.stream(values()).mapToInt(AreaEnum::getType).toArray();

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 名字
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAY;
    }
}
