package com.agoi.mapper;

import com.agoi.pojo.Drug;
import com.agoi.pojo.DrugStatus;

import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/20 11:58
 */
public interface DrugMapper {

//    List<Drug> findDrugs(@Param("drName") String drName,@Param("drType") String drType);

    List<DrugStatus> findAll();

    List<Drug> findDrugs(Map map);


    Integer insertDrug(Drug drug);

    List<Drug> find(Integer drId);

    Integer update(Drug drug);

    Integer addNum(Drug drug);

    List<Drug> findByIds(String[] strings);
}
