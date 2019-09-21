package com.agoi.service.impl;

import com.agoi.mapper.HosRegisterMapper;
import com.agoi.pojo.HosRegister;
import com.agoi.service.HosRegisterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/18 19:38
 */
@Service
public class HosRegisterServiceImpl implements HosRegisterService {

    @Resource
    private HosRegisterMapper hosRegisterMapper;


    @Override
    public PageInfo<HosRegister> getRegisters(Integer pageindex, Integer pagesize,
                                              Integer num, String dDoctorName,
                                              String dname, String beginTime, String endTime) {

        PageHelper.startPage(pageindex, pagesize);
        Map map = new HashMap();
        map.put("num", num);
        map.put("dDoctorName", dDoctorName);
        map.put("dname", dname);
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        List<HosRegister> list = hosRegisterMapper.getRegisters(map);
        System.out.println(list.size());
        return new PageInfo(list);
    }



    @Override
    public List<HosRegister> findByIds(String ids) {
        String[] strings = ids.split(",");
        return hosRegisterMapper.findByIds(strings);
    }
}
