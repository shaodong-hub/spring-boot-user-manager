package com.github.user.manager.security.core;

import com.google.common.collect.Maps;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 石少东
 * @date 2020-08-28 18:00
 * @since 1.0
 */

//@Primary
//@Component
public class SystemFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = Maps.newHashMap();

    @PostConstruct
    public void init() {
        requestMap.put(new AntPathRequestMatcher("/home1", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_ROOT"));
        requestMap.put(new AntPathRequestMatcher("/home2", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_USER"));
    }

    /**
     * 需要从这个对象中取出要访问的URL，然后再从数据库中取出这个访问这个 URL 需要哪些角色。
     *
     * @param object 实际是这个类型 {@link FilterInvocation}
     * @return Collection
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Collection<ConfigAttribute> collection = new ArrayList<>(Collections.singleton((ConfigAttribute) () -> "ROLE_ROOT"));
        requestMap.entrySet().stream().filter(one -> one.getKey().matches(request)).findFirst().ifPresent(one -> collection.addAll(one.getValue()));
        return collection;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<>();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
