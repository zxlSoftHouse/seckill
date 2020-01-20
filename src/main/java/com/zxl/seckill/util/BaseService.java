package com.zxl.seckill.util;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public abstract class BaseService<M extends BaseMapper<T>,T extends BaseModel> extends ServiceImpl<M, T> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected M baseMapper;
    /** 获取分页对象 */
    public Page<T> getPage(Map<String, Object> params) {
        Integer current = 1;
        Integer size = 10;
        String orderBy = "";
        boolean isAsc=true;
        if (DataUtil.isNotEmpty(params.get("pageNum"))) {
            current = Integer.valueOf(params.get("pageNum").toString());
        }
        if (DataUtil.isNotEmpty(params.get("pageSize"))) {
            size = Integer.valueOf(params.get("pageSize").toString());
        }
        if (DataUtil.isNotEmpty(params.get("orderBy"))) {
            orderBy = (String) params.get("orderBy");
        }
        Page<T> page = new Page<T>(current, size, orderBy);
        if (DataUtil.isNotEmpty(params.get("isAsc"))) {
            isAsc = Boolean.valueOf(params.get("isAsc").toString());
            page.setAsc(isAsc);
        }
        return page;
    }

    @Transactional
    @CacheEvict()
    public void delete(Map params) {
        List<T> list = queryList(params);
        for(T record:list) {
            delete(record);
        }
    }

    @Transactional
    @CacheEvict(key="target.getCacheName() + ':' + #id")
    public Integer delete(Long id) {
        try {
            //Long userId = ContextHolder.getUserId();
            T record = this.queryById(id);
            record.setDeletedFlag("1");
            return baseMapper.updateById(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional
    @CacheEvict(key="target.getCacheName() + ':' + #p0.rowId")
    public void delete(T record) {
        try {
            //Long userId = ContextHolder.getUserId();
            record.setDeletedFlag("1");
            baseMapper.updateById(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional
    public T update(T record) {
        try {
            //Long userid = ContextHolder.getUserId();
            if (record.getId() == null) {
                baseMapper.insert(record);
                record = queryById(record.getId());//数据库非主键字段的默认值,没有更新到bean中 2017年3月21日11:09:20 liyg
            } else {
                baseMapper.updateById(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
        return record;
    }

    @Transactional
    //@CachePut(key="target.getCacheName() + ':' + #p0.rowId")
    public T updateAllColumn(T record) {
        try {
            //Long userid = ContextHolder.getUserId();
            if (record.getId() == null) {
                //record.setCreateBy(userid);
                //record.setCreateTime(new Date());
                baseMapper.insert(record);
                record = queryById(record.getId());//数据库非主键字段的默认值,没有更新到bean中 2017年3月21日11:09:20 liyg
            } else {
                //record.setUpdateBy(userid);
                //record.setUpdateTime(new Date());
                baseMapper.updateAllColumnById(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
        return record;
    }

    @Transactional
    //@Cacheable(key="target.getCacheName() + ':' + #id")
    public T queryById(Long id) {
        try {
            T record = null;
            if (record == null) {
                record = baseMapper.selectById(id);
            }
            return record;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional
    public T queryOne(Map<String, Object> params) {
        Wrapper<T> wrapper = getWrapper(params);
        return selectOne(wrapper);
    }

    /**
     * 查询，带分页
     */
    public Page<T> queryPage(Map<String, Object> params) {
        Page<T> page = getPage(params);
        Wrapper<T> wrapper = getWrapper(params);
        return selectPage(page,wrapper);
    }
    /**
     * 查询所有
     */
    public List<T> queryList(Map<String, Object> params){
        Wrapper<T> wrapper = getWrapper(params);
        return selectList(wrapper);
    }
    public List<T> queryList(){
        return queryList(null);
    }
    /** 获取缓存键值 */
    public String getCacheName() {
        String cacheName = null;
        CacheConfig cacheConfig = getClass().getAnnotation(CacheConfig.class);
        if (cacheConfig == null || cacheConfig.cacheNames() == null
                || cacheConfig.cacheNames().length < 1) {
            cacheName = getClass().getName();
        } else {
            cacheName = cacheConfig.cacheNames()[0];
        }
        return cacheName;
    }

    public Wrapper<T> getWrapper(Map<String, Object> params){
        Wrapper<T> wrapper = new EntityWrapper<T>();
        wrapper.where("DELETED_FLAG={0}", "0");
        wrapper = wrapper(params, wrapper);
        return wrapper;
    }

    //各个模块自己实现，替代mybatis配置文件中的where
    public Wrapper<T> wrapper(Map<String, Object> params,Wrapper<T> wrapper){
        return wrapper;
    }
}
