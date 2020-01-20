package com.zxl.seckill.controller;

import com.zxl.seckill.entity.SeckillBusiness;
import com.zxl.seckill.service.SeckillBusinessService;
import com.zxl.seckill.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class SeckillBusinessController extends BaseController<SeckillBusinessService, SeckillBusiness> {

}
