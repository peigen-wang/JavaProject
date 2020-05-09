package com.javacode2020.chat04;

import com.javacode2020.chat04.mapper.NewsTypeMapper;
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
    public void getById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getById(6L);
            log.info("{}", userModel);
        }
    }

    @Test
    public void getById1() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            NewsTypeMapper mapper = sqlSession.getMapper(NewsTypeMapper.class);
            NewsTypeModel newsTypeModel = mapper.getById(2);
            log.info("{}", newsTypeModel);
        }
    }


    @Test
    public void getById2() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            NewsTypeMapper mapper = sqlSession.getMapper(NewsTypeMapper.class);
            NewsTypeModel newsTypeModel = mapper.getById2(3);
            log.info("{}", newsTypeModel);
        }
    }
}
