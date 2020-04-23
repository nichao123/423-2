package org.nichao.dao;

import org.nichao.pojo.DevUser;

public interface DevUserDao {
    public DevUser findByCode(String devCode);
}
