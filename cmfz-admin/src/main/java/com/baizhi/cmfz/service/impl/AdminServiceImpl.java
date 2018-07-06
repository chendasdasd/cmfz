package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.baizhi.cmfz.utils.SaltUtils.encryptionCode;

/**
 * Created by 陈少 on 2018/7/5.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public void register(Admin admin) {

        String uuid=UUID.randomUUID().toString().replaceAll("-", "");
        String salt=SaltUtils.getRandomSalt(6);

        admin.setMgr_id(uuid);
        admin.setSalt(salt);
        admin.setMgr_pwd(SaltUtils.encryptionCode(admin.getMgr_pwd()+salt));
        adminDao.insertAdmin(admin);
    }

    @Override
    public Admin login(String name, String password) {

        Admin admin = adminDao.selectByName(name);

        if (admin!=null){
            String nowPwd=SaltUtils.encryptionCode(password+admin.getSalt());

            if (nowPwd.equals(admin.getMgr_pwd())){
                return admin;
            }
        }
        return null;
    }

    @Override
    public void changePwd(String mgr_id, String newPwd) {

        String salt=SaltUtils.getRandomSalt(6);
        String pwd=SaltUtils.encryptionCode(newPwd+salt);

        adminDao.updatePwd(mgr_id,salt,pwd);

    }
}
