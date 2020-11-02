package com.hit.cggb.awesome.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.List;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 11/02/20,4:54 PM
 * @description json util
 */
public class JsonUtil {

    private static final SerializeConfig SNAKE_CASE_CONF = new SerializeConfig();

    static {
        SNAKE_CASE_CONF.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
    }

    private JsonUtil() {
    }

    public static String toJson(Object o) {
        return JSON.toJSONString(o);
    }

    public static String toSnakeCaseJson(Object o) {
        return JSON.toJSONString(o, SNAKE_CASE_CONF);
    }

    public static <T> T toEntity(Object o, Class<T> clazz) {
        String jsonStr = toJson(o);
        return JSON.parseObject(jsonStr, clazz);
    }

    public static <T> T toEntity(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
        return JSON.parseArray(jsonStr, clazz);
    }

    public static <T> List<T> toList(Object o, Class<T> clazz) {
        return JSON.parseArray(toJson(o), clazz);
    }
}
