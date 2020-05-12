package com.course.model.sql;

import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private User user;
    private List<Integer> ids;


}
