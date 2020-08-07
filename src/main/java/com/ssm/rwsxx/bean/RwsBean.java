package com.ssm.rwsxx.bean;

import java.io.Serializable;

/**
 * Created by sunsq on 2020/8/6.
 */
public class RwsBean implements Serializable {

    private String task_id;
    private String task_des;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_des() {
        return task_des;
    }

    public void setTask_des(String task_des) {
        this.task_des = task_des;
    }

    public RwsBean(String task_id) {
        this.task_id = task_id;
    }

    public RwsBean() {
    }
}