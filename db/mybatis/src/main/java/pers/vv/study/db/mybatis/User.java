package pers.vv.study.db.mybatis;

import lombok.Data;

@Data
public class User {

    private Long userId;

    private String name;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
