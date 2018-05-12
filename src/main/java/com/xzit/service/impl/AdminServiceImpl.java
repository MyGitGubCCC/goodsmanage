package com.xzit.service.impl;

import com.xzit.entity.Admin;
import com.xzit.entity.AdminExample;
import com.xzit.mapper.AdminMapper;
import com.xzit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/22.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    public Admin selectByExample(AdminExample example) {
        List<Admin> admins = adminMapper.selectByExample(example);
        Admin admin = null;
        if (admins.size()>0){
            admin = admins.get(0);
        }
        return admin;
    }
}
