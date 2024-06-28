package cn.edu.zust.se.util.json;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Author: ShenYi
 * @Date: 2024-06-28-21:35
 * @Description:
 * JSON工具类
 */
@Slf4j
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // 忽略 null 值
        objectMapper.registerModules(new JavaTimeModule()); // 解决 LocalDateTime 的序列化
    }
    /**
     * 初始化 objectMapper 属性
     *
     * 这样可以使用 Spring 创建的 ObjectMapper Bean
     * @param objectMapper ObjectMapper 对象
     */
    public static void init(ObjectMapper objectMapper) {
        JsonUtils.objectMapper = objectMapper;
    }
    @SneakyThrows
    public static String toJsonString(Object object) {
        return objectMapper.writeValueAsString(object);
    }
    @SneakyThrows
    public static byte[] toJsonByte(Object object) {
        return objectMapper.writeValueAsBytes(object);
    }
    @SneakyThrows
    public static String toJsonPrettyString(Object object) {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
    //将整个JSON字符转化为对象
    public static <T> T parseObject(String text, Class<T> clazz) {
        if (StrUtil.isEmpty(text)) {
            return null;
        }
        try {
            return objectMapper.readValue(text, clazz);
        } catch (Exception e) {
            log.error("json parse err,json:{}", text, e);
            throw new RuntimeException();
        }
    }
    //将JSON字符中的某块属性转为字符串，path填的就是属性名
    public static <T> T parseObject(String text, String path,Class<T> clazz){
        if (StrUtil.isEmpty(text)){
            return null;
        }
        try {
            JsonNode treeNode = objectMapper.readTree(text);
            JsonNode pathNode = treeNode.path(path);
            return objectMapper.readValue(pathNode.toString(),clazz);
        }catch (IOException e){
            log.error("json parse err,json:{}", text, e);
            throw new RuntimeException(e);
        }
    }
    //
    public static <T> T parseObject(String text, Type type){
        if (StrUtil.isEmpty(text)){
            return null;
        }
        try {
            return objectMapper.readValue(text,objectMapper.getTypeFactory().constructType(type));
        }catch (IOException e){
            log.error("json parse err,json:{}", text, e);
            throw new RuntimeException(e);
        }
    }
}
