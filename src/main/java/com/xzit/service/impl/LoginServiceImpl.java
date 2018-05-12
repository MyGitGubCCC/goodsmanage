package com.xzit.service.impl;

import com.xzit.entity.Admin;
import com.xzit.entity.Aunt;
import com.xzit.entity.Student;
import com.xzit.mapper.AdminMapper;
import com.xzit.mapper.AuntMapper;
import com.xzit.mapper.StudentMapper;
import com.xzit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caochengcheng on 2018/4/22.
 */
@Service
public class LoginServiceImpl implements LoginService {
     @Autowired
    private AdminMapper adminMapper;
     @Autowired
    private AuntMapper auntMapper;
     @Autowired
    private StudentMapper studentMapper;


    public int updatePwdByUsername(String username, String password) throws Exception {
        int state =0;
        if (username.indexOf("ad")!=-1){
            Admin admin = new Admin();
            admin.setAdminno(username);
            admin.setAdminpassword(password);
            state = adminMapper.updateAdminpasswordByAdminno(admin);
        }else if (username.indexOf("AY")!=-1){
            Aunt aunt = new Aunt();
            aunt.setAuntno(username);
            aunt.setAuntpassword(password);
            state = auntMapper.updateAuntpasswordByAuntno(aunt);
        }else {
            Student student = new Student();
            student.setSno(username);
            student.setSpwd(password);
            state = studentMapper.updateSpwdBySno(student);
        }
        return state;
    }
}
