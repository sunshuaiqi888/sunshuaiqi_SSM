package com.ssm.rwsxx.service;

import com.ssm.rwsxx.bean.RwsBean;

import java.util.List;

/**
 * Created by sunsq on 2020/8/6.
 */
public interface RwsService {

    List<RwsBean> rwslist() throws Exception;
}
