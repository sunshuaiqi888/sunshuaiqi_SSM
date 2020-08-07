package com.ssm.rwsxx.dao;

import com.ssm.rwsxx.bean.RwsBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunsq on 2020/8/6.
 */
@Repository
public interface RwsxxDao {

    List<RwsBean> rwslist() throws Exception;
}
