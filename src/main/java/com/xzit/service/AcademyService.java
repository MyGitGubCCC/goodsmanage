package com.xzit.service;

import com.xzit.entity.Academy;
import com.xzit.entity.AcademyExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
public interface AcademyService {
    List<Academy> selectByExample(AcademyExample example)throws Exception;
}
