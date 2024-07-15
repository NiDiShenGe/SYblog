package cn.edu.zust.se.core;

import cn.edu.zust.se.core.enums.AreaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: ShenYi
 * @Date: 2024-07-09-9:39
 * @Description:
 * 区域节点，包括国家、省份、城市、地区等信息
 * 数据可见 resources/area.csv 文件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    /**
     * 编号 - 全球，即根目录
     */
    public static final Integer ID_GLOBAL = 0;
    /**
     * 编号 - 中国
     */
    public static final Integer ID_CHINA = 1;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 类型
     *
     * 枚举 {@link AreaEnum}
     */
    private Integer type;

    /**
     * 父节点
     */
    private Area parent;
    /**
     * 子节点
     */
    private List<Area> children;
}
