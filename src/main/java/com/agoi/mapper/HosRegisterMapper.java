package com.agoi.mapper;

import com.agoi.pojo.HosRegister;

import java.util.List;
import java.util.Map;

/**
 * @author: agoi
 * @date 2019/09/18 19:39
 */
public interface HosRegisterMapper {

    List<HosRegister> getRegisters(Map map);

    List<HosRegister> findByIds(String[] strings);
}
