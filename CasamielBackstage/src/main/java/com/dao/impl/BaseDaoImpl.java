package com.dao.impl;

import com.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author peigen
 */
@Repository("baseDao")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    /**
     * T的具体类
     */
    private Class<T> clazz;

    protected static Logger logger = Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public BaseDaoImpl() {
        super();
        // 反射：第一步获得Class 正在被调用那个类的Class,CustomerDaoImpl或者LinkManDaoImpl。
        Class clazz = this.getClass();
        // 查看JDK的API
        // 参数化类型：BaseDaoImpl<Customer>，BaseDaoImpl<LinkMan>
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
        // 得到这个type就是一个参数化的类型， 将type强转成参数化的类型:
        ParameterizedType pType = (ParameterizedType) type;
        // 通过参数化类型获得实际类型参数:得到一个实际类型参数的数组？Map<String,Integer>.
        Type[] types = pType.getActualTypeArguments();
        // 只获得第一个实际类型参数即可。
        // 得到Customer、LinkMan、User
        this.clazz = (Class) types[0];
    }

    @Override
    public Object save(T entity) {
        return this.getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        this.getSession().update(entity);
    }


    @Override
    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    @Override
    public void delete(Serializable id) {
        T entity = get(id);
        delete(entity);
    }

    @Override
    public T get(Serializable id) {
        return this.getSession().get(clazz,id);
    }

    @Override
    public List<T> getList(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        if(params!=null && params.length>0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.list();
    }

    @Override
    public List<T> queryPage(String hql, int pageIndex, int pageSize, Object... params) {
        if(pageIndex<1){
            pageIndex=1;
        }
        Query query = this.getSession().createQuery(hql);
        if(params!=null && params.length>0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
       return query.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
    }

    @Override
    public int Count(String hql, Object... params) {
        int index = hql.toUpperCase().indexOf("FROM");
        Query query = this.getSession().createQuery("select count(*) "+hql.substring(index));
        if(params!=null && params.length>0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return (int)query.uniqueResult();
    }
}
