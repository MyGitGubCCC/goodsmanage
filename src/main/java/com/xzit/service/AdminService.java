package com.xzit.service;

import com.xzit.entity.Admin;
import com.xzit.entity.AdminExample;

/**
 * Created by caochengcheng on 2018/4/22.
 */
public interface AdminService {
    Admin selectByExample(AdminExample example);
}
