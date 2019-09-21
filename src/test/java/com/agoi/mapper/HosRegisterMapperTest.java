package com.agoi.mapper;

import com.agoi.pojo.HosRegister;
import com.ssmTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/18 21:39
 */
public class HosRegisterMapperTest extends ssmTest {

    @Autowired
    private HosRegisterMapper hosRegisterMapper;

    @Test
    public void getRegisters() {
        Map map = new HashMap();
        map.put("num", 1);
        map.put("dDoctorName", "医");
        map.put("dname", null);
        map.put("beginTime", null);
        map.put("endTime", null);
        List<HosRegister> registers = hosRegisterMapper.getRegisters(map);
        for (HosRegister register : registers) {
            System.out.println(register);
        }

    }




}


