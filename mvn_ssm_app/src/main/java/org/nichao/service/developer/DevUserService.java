package org.nichao.service.developer;

import org.nichao.pojo.DevUser;

public interface DevUserService {
    public DevUser findByCode(String devCode);
}
