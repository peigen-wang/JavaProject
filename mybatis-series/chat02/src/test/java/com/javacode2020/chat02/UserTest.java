package com.javacode2020.chat02;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;


@Slf4j
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory =sqlSessionFactory;
    }

    @Test
    public  void  SqlSession(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        log.info("{}",sqlSession);
    }

    @Test
    public void insertUser(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserModel userModel = UserModel.builder().name("peigen").salary(1000D).age(30).build();
            int result = sqlSession.insert("com.javacode2020.chat02.UserMapper.insertUser",userModel);
            log.info("插入影响行数：{}",result);
            sqlSession.commit();
        }
    }

    @Test
    public  void  insertWithMapper(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            UserModel userModel = UserModel.builder().name("peigen").salary(1000D).age(30).build();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int result = mapper.insertUser(userModel);
            log.info("插入影响行数：{}",result);
            //sqlSession.commit();
        }
    }

}
