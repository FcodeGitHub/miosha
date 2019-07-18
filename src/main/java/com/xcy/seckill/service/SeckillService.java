package com.xcy.seckill.service;

import com.xcy.seckill.pojo.DataResult;
import com.xcy.seckill.pojo.Seckill;
import com.xcy.seckill.pojo.SuccessKilled;

import java.util.List;

public interface SeckillService {
    List<Seckill> getSeckillList();

    Seckill getSeckillById(long id);

    DataResult execSecKillHandler(SuccessKilled successKilled);
}
