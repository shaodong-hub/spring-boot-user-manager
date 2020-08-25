package com.github.user.manager.security.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-08-22 17:24
 * @since 1.0
 */


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -9016572856407681481L;

    private static final String SUCCESS = "success";

    private static final String FAILURE = "failure";

    private Integer status;

    private T data;

    private String message;

    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder().status(200).message(SUCCESS).build();
    }

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder().status(200).message(SUCCESS).data(data).build();
    }

    public static <T> ResultVO<T> success(T data, String message) {
        return ResultVO.<T>builder().status(200).data(data).message(message).build();
    }

    public static <T> ResultVO<T> failure() {
        return ResultVO.<T>builder().status(500).message(FAILURE).build();
    }

    public static <T> ResultVO<T> failure(String message) {
        return ResultVO.<T>builder().status(500).message(message).build();
    }

}
