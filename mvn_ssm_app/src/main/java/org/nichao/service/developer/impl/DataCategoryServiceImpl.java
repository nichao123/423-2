package org.nichao.service.developer.impl;


import org.nichao.dao.DataDictionaryDao;
import org.nichao.pojo.DataDictionary;
import org.nichao.service.developer.DataDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DataCategoryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryDao dataDictionaryDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<DataDictionary> appzhuangtai() {
        return dataDictionaryDao.appzhuangtai();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<DataDictionary> apppintai() {
        return dataDictionaryDao.apppintai();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<DataDictionary> appfabuzhuangtai() {
        return dataDictionaryDao.appfabuzhuangtai();
    }
}
