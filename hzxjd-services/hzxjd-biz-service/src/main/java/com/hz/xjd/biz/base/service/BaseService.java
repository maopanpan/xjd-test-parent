package com.hz.xjd.biz.base.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.Mapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * service的基类
 * @author hujunlong
 *
 * @param <T>
 */
public class BaseService<D extends Mapper<T>, T extends Serializable> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected D baseDao;

    private Class<?> clazz = null;

    protected Class<?> getEntityClass() {
    	if (clazz == null) {
    		clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    	}
    	return clazz;
    }


	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
    public int insert(T entity) {
        return baseDao.insert(entity);
    }

	/**
	 * 只插入不为null的字段,不会影响有默认值的字段
	 * @param entity
	 * @return
	 */
    public int insertSelective(T entity) {
        return baseDao.insertSelective(entity);
    }

	/**
	 * 根据主键更新数据
	 * @param entity
	 * @return
	 */
    public int updateByPrimaryKey(T entity) {
        return baseDao.updateByPrimaryKey(entity);
    }

	/**
	 * 根据主键更新添加非空值，null不会被更新
	 * @param entity
	 * @return
	 */
    public int updateByPrimaryKeySelective(T entity) {
        return baseDao.updateByPrimaryKeySelective(entity);
    }

	/**
	 * 根据主键删除数据
	 * @param entity
	 * @return
	 */
    public int deleteByPrimaryKey(Object primaryKey) {
        return baseDao.deleteByPrimaryKey(primaryKey);
    }

	/**
	 * 根据主键list批量删除数据
	 * @param entity
	 * @return
	 */
    public int deleteByPrimaryKeys(List<Object> primaryKeys) {
        int resulrt = 0;
        for (Object primaryKey : primaryKeys) {
            resulrt += baseDao.deleteByPrimaryKey(primaryKey);
        }
        return resulrt;
    }

	/**
	 * 根据指定字段值删除，判断条件为等号
	 * @param field
	 * @param value
	 * @return
	 */
    public int deleteByField(String field, String value) {
        return deleteByFields(new String[] { field }, new String[] { value });
    }

	/**
	 * 根据指定字段值list删除，判断条件为等号
	 * @param fields
	 * @param values
	 * @return
	 */
    public int deleteByFields(String[] fields, String[] values) {
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {
            return 0;
        }
        Example example = new Example(getEntityClass());
        Criteria criteria = example.createCriteria();
        for (int i = 0; i < fields.length; i++) {
            criteria.andEqualTo(fields[i], values[i]);
        }
        return baseDao.deleteByExample(example);
    }

	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param entity
	 * @return
	 */
    public T selectOne(T entity) {
        return baseDao.selectOne(entity);
    }

	/**
	 * 根据实体中的主键进行查询，查询条件使用等号
	 * @param primaryKey
	 * @return
	 */
    public T selectByPrimaryKey(Object primaryKey) {
        return baseDao.selectByPrimaryKey(primaryKey);
    }

	/**
	 * 单表分页查询 [selectPage(0,0) return all ]
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    public List<T> selectWithPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return baseDao.selectAll();
    }

	/**
	 * 根据指定字段值分页查询
	 * @param field
	 * @param value
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    public List<T> selectByEqFieldWithPage(String field, String value, int pageNum, int pageSize){
        return selectByEqFieldsWithPage(new String[] { field }, new String[] { value }, pageNum, pageSize);
    }

	/**
	 * 根据指定字段值list分页查询
	 * @param fields
	 * @param values
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    public List<T> selectByEqFieldsWithPage(String[] fields, String[] values, int pageNum, int pageSize) {
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {
            return null;
        }
        Example example = new Example(getEntityClass());
        Criteria criteria = example.createCriteria();
        for (int i = 0; i < fields.length; i++) {
            criteria.andEqualTo(fields[i], values[i]);
        }
        PageHelper.startPage(pageNum, pageSize);
        return baseDao.selectByExample(example);
    }

}
