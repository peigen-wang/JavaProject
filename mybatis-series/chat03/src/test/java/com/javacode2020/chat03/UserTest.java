package com.javacode2020.chat03;


import com.javacode2020.chat03.mapper.UserMapper;
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
    public void insertUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = UserModel.builder().name("培根").age(31).salary(15000D).build();
            int result = mapper.insertUser(userModel);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = UserModel.builder().id(114L).name("培1根").age(31).build();
            //执行更新操作
            long result = mapper.updateUser(userModel);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //定义需要删除的用户id
            Long userId = 100L;
            //执行删除操作
            boolean result = mapper.deleteUser(userId);
            log.info("第1次删除:id={},返回值:{}", userId, result);
            userId = 101L;
            result = mapper.deleteUser(userId);
            log.info("第2次删除:id={},返回值:{}", userId, result);
        }
    }

}
