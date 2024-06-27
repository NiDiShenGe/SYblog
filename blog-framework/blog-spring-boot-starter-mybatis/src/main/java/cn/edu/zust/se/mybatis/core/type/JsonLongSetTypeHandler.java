package cn.edu.zust.se.mybatis.core.type;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Set;

/**
 * @Author: ShenYi
 * @Date: 2024-06-27-22:52
 * @Description:
 */
public class JsonLongSetTypeHandler extends AbstractJsonTypeHandler<Object> {
    private static final TypeReference<Set<Long>> TYPE_REFERENCE = new TypeReference<Set<Long>>(){};
    @Override
    protected Object parse(String json) {
        return null;
    }

    @Override
    protected String toJson(Object obj) {
        return null;
    }
}
