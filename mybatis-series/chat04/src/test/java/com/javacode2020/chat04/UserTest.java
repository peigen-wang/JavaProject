package com.javacode2020.chat04;

import com.javacode2020.chat04.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void Before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getById(){
        try(SqlSession sqlSession= sqlSessionFactory.openSession(true)){
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getById(6L);
            log.info("{}",userModel);
        }
    }

}
