package com.hcx.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by hongcaixia on 2020/2/10.
 */
@Data
@ToString
@Entity
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
