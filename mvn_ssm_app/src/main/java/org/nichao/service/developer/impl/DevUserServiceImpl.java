package org.nichao.service.developer.impl;

import org.nichao.dao.DevUserDao;
import org.nichao.pojo.DevUser;
import org.nichao.service.developer.DevUserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserDao devUserDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public DevUser findByCode(String devCode) {
        return devUserDao.findByCode(devCode);
    }
}
