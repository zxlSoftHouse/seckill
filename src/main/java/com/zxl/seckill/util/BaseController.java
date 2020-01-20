package com.zxl.seckill.util;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class BaseController<S extends BaseService<?, T>, T extends BaseModel> {

    @Autowired
    protected S service;

    /**
     * (基类提供)新增或修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public T update(@RequestBody T record) {
        return service.update(record);
    }

    /**
     * (基类提供)根据ID删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * (基类提供)根据ID查询
     */
    @RequestMapping(value = "/queryById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public T queryById(@PathVariable Long id) {
        return service.queryById(id);
    }

    /**
     * (基类提供)根据组合条件查询出一条记录
     */
    @RequestMapping(value = "/queryOne",method = RequestMethod.POST)
    @ResponseBody
    public T queryOne(@RequestBody Map<String, Object> params) {
        return service.queryOne(params);
    }

    /**
     * (基类提供)查询所有满足条件的记录
     */
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    @ResponseBody
    public List<T> queryList(@RequestBody Map<String, Object> params) {
        return service.queryList(params);
    }

    /**
     * (基类提供)按分页查询所有满足条件的记录
     */
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    @ResponseBody
    public Page<T> queryPage(@RequestBody Map<String, Object> params) {
        return service.queryPage(params);
    }
}
