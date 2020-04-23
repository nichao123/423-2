package org.nichao.service.developer.impl;

import org.nichao.dao.AppCategoryDao;
import org.nichao.pojo.AppCategory;
import org.nichao.service.developer.AppCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<AppCategory> firstGrade() {
        return appCategoryDao.firstGrade();
    }

    @Override
    public List<AppCategory> secondGrade(int parentId) {
        return appCategoryDao.secondGrade(parentId);
    }
}
