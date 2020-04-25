package com.javacode2020.chat02;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

@Slf4j
public class ProxyTest {
    public static class UserMapperProxy implements InvocationHandler {
        private SqlSession sqlSession;
        private Class<?> mapperClass;

        public UserMapperProxy(SqlSession sqlSession, Class<?> mapperClass) {
            this.sqlSession = sqlSession;
            this.mapperClass = mapperClass;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.debug("invoke start");
            String statement = mapperClass.getName() + "." + method.getName();
            //测试代码仅执行一个方法
            //源码此处是有个 mapperMethod.execute(this.sqlSession, args)方法
            List<Object> result = sqlSession.selectList(statement);
            log.debug("invoke end");
            return result;
        }
    }

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
    public void test1() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            UserMapper usermapper = (UserMapper) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{UserMapper.class}, new UserMapperProxy(sqlSession, UserMapper.class));
            List<UserModel> userModelList = usermapper.getUserList();
            log.info("结果：{}", userModelList);
        }
    }
}
