package com.agoi.mapper;

import com.agoi.pojo.Drug;
import com.agoi.pojo.DrugStatus;
import com.ssmTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/20 14:27
 */
public class DrugMapperTest extends ssmTest {

    @Resource
    private DrugMapper drugMapper;


    @Test
    public void findAll() {
        List<DrugStatus> all = drugMapper.findAll();
        for (DrugStatus status : all) {
            System.out.println(status);
        }
    }


    @Test
    public void findDrugs() {

        Map map = new HashMap();
        map.put("drName", null);
        map.put("drType", -1);
        List<Drug> drugs = drugMapper.findDrugs(map);
        for (Drug drug : drugs) {
            System.out.println(drug.getDrName());
        }
    }

    @Test
    public void insertDrug() {
        Drug drug = new Drug();
        drug.setDrId(10);
        drug.setdrFactory("大牛");
        Integer integer = drugMapper.insertDrug(drug);
    }

    @Test
    public void find() {
        List<Drug> drugs = drugMapper.find(2);
        for (Drug drug : drugs) {
            System.out.println(drug.getDrName());
        }
    }

}