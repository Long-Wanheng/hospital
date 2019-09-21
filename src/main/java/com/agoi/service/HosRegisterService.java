package com.agoi.service;

import com.agoi.pojo.HosRegister;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/18 19:38
 */
public interface HosRegisterService {

    PageInfo<HosRegister> getRegisters(Integer pageindex, Integer pagesize, Integer num, String dDoctorName, String dname, String beginTime, String endTime);

    List<HosRegister> findByIds(String ids);
}
