package com.agoi.controller;

import com.agoi.pojo.HosRegister;
import com.agoi.service.HosRegisterService;
import com.agoi.utils.ExcelUtil;
import com.agoi.utils.InterfaceUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/18 19:35
 */
@Controller
public class HosRegisterController {

    @Resource
    private HosRegisterService hosRegisterService;

    @RequestMapping("/getregisters")
    public String getregs(@RequestParam(defaultValue = "1")Integer pageindex,
                          @RequestParam(defaultValue = "-1")Integer num,
                          String dDoctorName, String dname, String beginTime, String endTime,
                          ModelMap map){
        PageInfo<HosRegister> pageInfo =
                hosRegisterService.getRegisters(pageindex, InterfaceUtil.PAGESIZE,num,dDoctorName,dname,beginTime,endTime);
        map.addAttribute("pageInfo", pageInfo);
        map.addAttribute("num", num);
        map.addAttribute("dDoctorName", dDoctorName);
        map.addAttribute("dname", dname);
        map.addAttribute("beginTime", beginTime);
        map.addAttribute("endTime", endTime);
        return "/registration/index";
    }

    //查询选中数据
    @RequestMapping("/findbyids")
    public void findByIds(String ids, HttpServletResponse response){
        //查询选中
        List<HosRegister> hosRegisters = hosRegisterService.findByIds(ids);
        //导出excel
        ExcelUtil.createFirst(new String[]{"门诊编号","主治医生","挂号时间","挂号科室","状态"});
        ExcelUtil.creatother(hosRegisters);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String fmt = format.format(date);
        response.setContentType("application/x-download");
        String fileName = fmt+".xls";
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            ExcelUtil.export(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
