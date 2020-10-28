package com.github.user.manager.security.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author 石少东
 * @date 2020-10-27 20:49
 * @since 1.0
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryConditionsDTO {

    private String username;

    private String mobile;

    private String email;

    private Boolean preset;

    private Date startDate;

    private Date endDate;

}
