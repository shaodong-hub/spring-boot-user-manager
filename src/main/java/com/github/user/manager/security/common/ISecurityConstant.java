package com.github.user.manager.security.common;

/**
 * @author 石少东
 * @date 2020-08-24 10:47
 * @since 1.0
 */

public interface ISecurityConstant {

    String GET = "GET";

    String POST = "POST";

    String SYSTEM_LOGIN_USERNAME = "/system/login/username";

    String SYSTEM_LOGIN_LOGOUT = "/system/login/logout";

    String SYSTEM_TRIAL_CAPTCHA = "/system/trial/image";

    /**
     * 申请试用页 - 短信验证码校验的路径
     */
    String TRIAL_SMS_CODE_VALIDATE_PATH = "/share/trial/apply";
    /**
     * 申请试用页 - 图形验证码获取和校验接口
     */
    String TRIAL_IMAGE_CODE_VALIDATE_PATH = "/share/image/code";

}
