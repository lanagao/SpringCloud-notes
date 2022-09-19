package com.angx.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description: 声明常用返回值，在类上标记T表示使用泛类
 * @author Angx Gao
 * @create 2022/9/10
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    /*
     * @description: this()调用已有构造器，向全参构造器传入两个参并返回
     * @return code and message without data
     * @author Angx Gao
     * @create 2022/9/10
     **/
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
