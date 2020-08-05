package pers.vv.study.db.mybatis;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;

    private String name;

}
