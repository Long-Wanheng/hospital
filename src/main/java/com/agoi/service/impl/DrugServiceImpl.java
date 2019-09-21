package com.agoi.service.impl;

import com.agoi.mapper.DrugMapper;
import com.agoi.pojo.Drug;
import com.agoi.pojo.DrugStatus;
import com.agoi.service.DrugService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/20 11:58
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Resource
    private DrugMapper drugMapper;


    @Override
    public PageInfo<Drug> findDrugs(Integer pageindex, Integer pagesize, String drName,Integer drType) {
        PageHelper.startPage(pageindex, pagesize);
        Map map = new HashMap();
        map.put("drName", drName);
        map.put("drType", drType);
        List<Drug> drugs = drugMapper.findDrugs(map);
        System.out.println(drugs.size());
        PageInfo pageInfo = new PageInfo(drugs);
        return pageInfo;
    }

    @Override
    public List<DrugStatus> findAll() {
        return drugMapper.findAll();
    }

    //添加药品
    @Override
    public Integer insertDrug(Drug drug) {
        return drugMapper.insertDrug(drug);
    }


    @Override
    public List<Drug> find(Integer drId) {
        return drugMapper.find(drId);
    }

    @Override
    public Integer update(Drug drug) {
        return drugMapper.update(drug);
    }


    @Override
    public Integer addNum(Drug drug) {
        return drugMapper.addNum(drug);
    }


    //导出

    @Override
    public List<Drug> findByIds(String ids) {
        String[] strings = ids.split(",");
        return drugMapper.findByIds(strings);
    }
}
