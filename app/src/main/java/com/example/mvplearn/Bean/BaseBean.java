/**
 * Copyright 2023 bejson.com
 */
package com.example.mvplearn.Bean;
import java.util.List;

/**
 * Auto-generated: 2023-04-10 20:54:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BaseBean <T>{

    private int code;
    private String massage;
    private T data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
    public String getMassage() {
        return massage;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

}