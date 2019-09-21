package com.agoi.service.impl;

import com.agoi.pojo.Drug;
import com.agoi.service.DrugService;
import com.github.pagehelper.PageInfo;
import com.ssmTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author: agoi
 * @date 2019/09/20 15:52
 */
public class DrugServiceImplTest extends ssmTest {

    @Resource
    private DrugService drugService;

    @Test
    public void findDrugs() {
        PageInfo<Drug> drugs = drugService.findDrugs(1, 3, null, null);
        System.out.println(drugs.getList().size());
    }
}