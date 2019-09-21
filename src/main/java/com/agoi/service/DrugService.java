package com.agoi.service;

import com.agoi.pojo.Drug;
import com.agoi.pojo.DrugStatus;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/20 11:58
 */
public interface DrugService {
    PageInfo<Drug> findDrugs(Integer pageindex, Integer pagesize, String drName,Integer drType);

    List<DrugStatus> findAll();

    //添加药品
    Integer insertDrug(Drug drug);

    List<Drug> find(Integer drId);

    Integer update(Drug drug);

    Integer addNum(Drug drug);

    List<Drug> findByIds(String ids);
}
