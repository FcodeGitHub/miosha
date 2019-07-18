package com.xcy.seckill.mapper;

import com.xcy.seckill.pojo.Seckill;
import com.xcy.seckill.pojo.SuccessKilled;

import java.util.List;

public interface SeckillMapper {
    List<Seckill> getSeckillList();
    Seckill getSeckillById(long id);

    int insertSuccessKilled(SuccessKilled successKilled);

    int jianKuCun(Long seckillId);
}
