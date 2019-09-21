package com.agoi.service.impl;

import com.agoi.mapper.MenuMapper;
import com.agoi.pojo.Menu;
import com.agoi.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/19 15:59
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }
}
