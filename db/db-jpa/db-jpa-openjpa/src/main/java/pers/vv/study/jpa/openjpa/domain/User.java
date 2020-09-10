package pers.vv.study.jpa.openjpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "user")
public class User {
    
    @Id
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "create_time")
    private Date createTime;
    
}
