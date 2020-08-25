package com.github.user.manager;

import cn.hutool.core.map.FixedLinkedHashMap;

import java.util.Date;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 00:01
 * @since 1.0
 */


public class FixedLinkedHashMapTest {

    private static final Map<String, String> history = new FixedLinkedHashMap<>(5);

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            history.put(i + "", i + "");
        }
        for (Map.Entry<String, String> entry : history.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

    }

}
