package com.pa.chen.appipc.bean;

import java.io.Serializable;

//实现Serializable序列化接口
public class User implements Serializable {
    private static final long serialVersionUID = -8083060784591162322L;

    public User(String userId, String name, String sex) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
    }

    public String userId;
    public String name;
    public String sex;


}
