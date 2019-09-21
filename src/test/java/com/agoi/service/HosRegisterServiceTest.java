package com.agoi.service;

import com.agoi.pojo.HosRegister;
import com.github.pagehelper.PageInfo;
import com.ssmTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: agoi
 * @date 2019/09/18 21:43
 */
public class HosRegisterServiceTest extends ssmTest {

    @Autowired
    private HosRegisterService hosRegisterService;

    @Test
    public void getRegisters() {
        PageInfo<HosRegister> registers = hosRegisterService.getRegisters(1, 2, null, null, null, null, null);
        System.out.println(registers);
    }
}