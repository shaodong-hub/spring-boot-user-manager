package com.github.user.manager.application.controller.impl;

import com.github.user.manager.application.controller.IIndexController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-08-22 17:23
 * @since 1.0
 */


@RestController
public class IndexControllerImpl implements IIndexController {

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    @Override
    public String redirect() {
        return "/";
    }

    @GetMapping("/index")
    @PreAuthorize("permitAll()")
    @Override
    public String index() {
        return "index";
    }
}
