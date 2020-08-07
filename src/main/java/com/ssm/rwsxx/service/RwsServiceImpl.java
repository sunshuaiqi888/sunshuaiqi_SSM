package com.ssm.rwsxx.service;

import com.ssm.rwsxx.bean.RwsBean;
import com.ssm.rwsxx.dao.RwsxxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunsq on 2020/8/6.
 */
@Service
public class RwsServiceImpl implements RwsService{

    @Autowired
    private RwsxxDao rwsxxDao;

    public List<RwsBean> rwslist() throws Exception {
        return rwsxxDao.rwslist();
    }
}