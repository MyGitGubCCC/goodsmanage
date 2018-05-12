package com.xzit.service;

import com.xzit.entity.Dormitory;
import com.xzit.entity.DormitoryExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
public interface DormitoryService {
    List<Dormitory> selectByExample(DormitoryExample example);
}
