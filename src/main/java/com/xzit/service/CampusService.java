package com.xzit.service;

import com.xzit.entity.Campus;
import com.xzit.entity.CampusExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
public interface CampusService {
    List<Campus> selectByExample(CampusExample example)throws Exception;
}
