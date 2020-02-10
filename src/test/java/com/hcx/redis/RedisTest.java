package com.hcx.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcx.SpringbootJpaApplication;
import com.hcx.domain.User;
import com.hcx.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by hongcaixia on 2020/2/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
        //获取数据
        String userList = redisTemplate.boundValueOps("userList").get();
        if(null==userList){
            List<User> users = userRepository.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            userList = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("userList").set(userList);
            System.out.println("从数据库中查询");
        }else {
            System.out.println("从redis中查询");
        }

        System.out.println(userList);

    }

}
