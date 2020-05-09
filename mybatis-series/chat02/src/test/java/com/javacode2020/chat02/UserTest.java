package com.javacode2020.chat02;

import com.javacode2020.chat02.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Test
    public void SqlSession() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        log.info("{}", sqlSession);
    }

    @Test
    public void insertUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserModel userModel = UserModel.builder().name("peigen").salary(1000D).age(30).build();
            int result = sqlSession.insert("com.javacode2020.chat02.UserMapper.insertUser", userModel);
            log.info("插入影响行数：{}", result);
            sqlSession.commit();
        }
    }

    @Test
    public void insertWithMapper() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserModel userModel = UserModel.builder().name("peigen").salary(1000D).age(30).build();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int result = mapper.insertUser(userModel);
            log.info("插入影响行数：{}", result);
            //sqlSession.commit();
        }
    }

    /**
     * 单个参数
     */
    @Test
    public void getByName() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByName("peigen");
            log.info("{}", userModel);
        }
    }

    /**
     * 实体值
     */
    @Test
    public void getListByUserFindDto() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserFindDto userFindDto = UserFindDto.builder().userId(20L).userName("peigen").build();
            List<UserModel> userModelList = userMapper.getListByUserFindDto(userFindDto);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    /**
     * 多个自定义参数
     */
    @Test
    public void getByIdOrName() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByIdOrName(20L, "peigen");
            log.info("{}", userModel);
        }
    }

    /**
     * ResultHandler 处理
     */
    @Test
    public void getList() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.getList(resultContext -> {
                DefaultResultContext<UserModel> defaultResultContext = (DefaultResultContext<UserModel>) resultContext;
                log.info("{}", defaultResultContext.getResultObject());
                if (defaultResultContext.getResultCount() == 10) {
                    defaultResultContext.stop();
                }
            });
        }
    }

    @Test
    public void getListByIds() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> ids = Arrays.asList(1L, 3L, 10L, 20L, 21L);
            List<UserModel> userModelList = userMapper.getListByIds(ids);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

}
