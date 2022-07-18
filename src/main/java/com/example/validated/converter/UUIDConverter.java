package com.example.validated.converter;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.UUID;

/**
 * 自定义参数转换器，处理UUID参数转换
 * 注意：UUID需要放在某一个实体内，即不可以直接在接口参数上使用UUID格式
 */
@Configuration
public class UUIDConverter implements Converter<String, UUID> {

    @Override
    @Nullable
    public UUID convert(final String source) {
        return StrUtil.isBlank(source) ? null : UUID.fromString(source.trim());
    }
}
