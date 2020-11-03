package com.github.user.manager.security.util;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * @author 石少东
 * @date 2020-10-28 20:11
 * @since 1.0
 */


public class UpdateUtil {

    /**
     * 将目标源中不为空的字段过滤，将数据库中查出的数据源复制到提交的目标源中
     *
     * @param source 用id从数据库中查出来的数据源
     * @param target 提交的实体，目标源
     */
    public static <T> void copyNullProperties(T source, T target) {
        BeanUtils.copyProperties(source, target, getNoNullProperties(target));
    }

    /**
     * @param target 目标源数据
     * @return 将目标源中不为空的字段取出
     */
    private static <T> String[] getNoNullProperties(T target) {
        BeanWrapper srcBean = new BeanWrapperImpl(target);
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        return Arrays.stream(pds)
                .filter(one -> ObjectUtils.isNotEmpty(srcBean.getPropertyValue(one.getName())))
                .map(FeatureDescriptor::getName)
                .toArray(String[]::new);
    }

}
