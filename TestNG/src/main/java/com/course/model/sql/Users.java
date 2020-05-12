package com.course.model.sql;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Users implements Serializable {
    private String id;
    private String name;
    private String fullname;
    private String mobile;
    private String organ;
    private String code;
    private Date code_time;
    private Integer enabled;
    private Date create_time;
    private String create_userid;
    private Date updete_time;
    private String Updete_userid;
    private String appcode;
    private String password;
    private Integer del_flag;
    private String token;
    private String saleman_token;
}
