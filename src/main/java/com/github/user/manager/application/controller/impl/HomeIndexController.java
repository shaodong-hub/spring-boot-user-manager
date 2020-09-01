package com.github.user.manager.application.controller.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 石少东
 * @date 2020-08-30 14:52
 * @since 1.0
 */

@RestController
public class HomeIndexController {

    @GetMapping("/home1")
    public String home1() {
        return "home1";
    }

    @GetMapping("/home2")
    @PreAuthorize("hasAnyRole('ROLE_ROOT')")
    public String home2() {
        return "home2";
    }

    @GetMapping("/1")
    public String r1() throws Exception {
//        sec("/home1", "ROLE_ROOT");
        return "r1";
    }

    @GetMapping("/2")
    public String r2() throws Exception {
//        sec("/home1", "ROLE_USER");
        CopyOnWriteArrayList<Long> list = new CopyOnWriteArrayList<>();
        return "r2";
    }

}
