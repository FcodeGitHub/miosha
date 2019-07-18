package com.xcy.seckill.controller;

import com.xcy.seckill.pojo.DataResult;
import com.xcy.seckill.pojo.Seckill;
import com.xcy.seckill.pojo.SuccessKilled;
import com.xcy.seckill.service.SeckillService;
import com.xcy.seckill.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SecKillController {

    private static String salt="l!a@o$y%a^n&";

    @Autowired
    SeckillService seckillService;


    @RequestMapping( value="/seckillList",method = RequestMethod.GET)
    public List<Seckill> getSeckillList(){
      return  seckillService.getSeckillList();
    }

    @RequestMapping("/getSeckillById")
    public Seckill getSeckillById(int id){
        return  seckillService.getSeckillById(id);
    }

    @RequestMapping("/getSeckillUrl")
    public String getSeckillUrl(int seckillId){
        // http://xxxxx://execution/seckillId/md5

        String md5 = MD5Utils.getMD5(seckillId+salt);
        return seckillId+"/"+md5;
    }

    @RequestMapping("/getNowTime")
    public Long getNowTime(){
        Date date =new Date();
        return date.getTime();
    }

    // localhost:80/xxx/exeSeckill/1001/xcdfsdfsdfdsdsdf
    @RequestMapping("/exeSeckill/{id}/{md5}")
    //@Transactional
    public DataResult exeSeckill(@PathVariable("id") Long seckillId, @PathVariable("md5") String md5, @CookieValue("userPhone") String userPhone){
        //开始执行秒杀
        String md5Str = MD5Utils.getMD5(seckillId+salt);
        if(!md5.equals(md5Str) || seckillId == 0){
            return new DataResult(1,"非法链接");
        }
        SuccessKilled successKilled =new SuccessKilled();
        successKilled.setCreateTime(new Date());
        successKilled.setSeckillId(seckillId);
        successKilled.setUserPhone(Long.valueOf(userPhone));
        successKilled.setState((byte)0);

       return seckillService.execSecKillHandler(successKilled);

    }
}
