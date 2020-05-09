package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author peigen
 */
public interface BaseDao<T> {

    /**
     * 添加一个对象
     *
     * @param entity
     */
    Object save(T entity);

    /**
     * 更新一个对象，所有属性
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据实体删除对象
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据主键id删除一个对象
     *
     * @param id
     */
    void delete(Serializable id);

    /**
     * 根据id查找一个对象
     *
     * @param id
     * @return
     */
    T get(Serializable id);

    /**
     * 根据HQL返回对象List
     *
     * @param hql
     * @param params
     * @return
     */
    List<T> getList(String hql, Object... params);

    /**
     * 分页查询
     *
     * @param hql
     * @param pageIndex
     * @param pageSize
     * @param params
     * @return
     */
    List<T> queryPage(String hql, int pageIndex, int pageSize, Object... params);

    /**
     * 查询记录总数
     *
     * @param hql
     * @param params
     * @return
     */
    int Count(final String hql, final Object... params);


}
