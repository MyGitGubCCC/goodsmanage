package com.xzit.service.impl;

import com.xzit.entity.Academy;
import com.xzit.entity.AcademyExample;
import com.xzit.mapper.AcademyMapper;
import com.xzit.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
@Service
public class AcademyServiceImpl implements AcademyService {

    @Autowired
    private AcademyMapper academyMapper;
    public List<Academy> selectByExample(AcademyExample example) throws Exception {
        return academyMapper.selectByExample(example);
    }
}
