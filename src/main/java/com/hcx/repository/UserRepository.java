package com.hcx.repository;


import com.hcx.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hongcaixia on 2020/2/10.
 */
public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findAll();
}
