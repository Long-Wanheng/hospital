package com.agoi.controller;

import com.agoi.pojo.Drug;
import com.agoi.pojo.DrugStatus;
import com.agoi.service.DrugService;
import com.agoi.utils.InterfaceUtil;
import com.agoi.utils.JavaExcelUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @date 2019/09/20 11:53
 */
@Controller
public class DrugController {

    @Resource
    private DrugService drugService;

    public List<DrugStatus> find(){
        List<DrugStatus> drugStatuses = drugService.findAll();
        return drugStatuses;
    }

    //跳转到药品管理首页
    @RequestMapping("/getdrugs")
    public String getDrugs(String drName, Integer drType, @RequestParam(defaultValue = "1")Integer pageindex, Model model){
        PageInfo<Drug> pageInfo = drugService.findDrugs(pageindex, InterfaceUtil.PAGESIZE,drName,drType);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("drName", drName);
        model.addAttribute("drType", drType);
        List<DrugStatus> drugStatuses = drugService.findAll();
        model.addAttribute("drugStatuses", drugStatuses);
        return "medicine/index";
    }



    //跳转到新增页面
    @RequestMapping("/adddrugs")
    public String addDrugs(Model model){
        List<DrugStatus> drugStatuses = find();
        model.addAttribute("drugStatuses", drugStatuses);
        return "medicine/add";
    }


    //添加药品
    @RequestMapping("/add")
    public String add(Drug drug){
        Integer count = drugService.insertDrug(drug);
        return "redirect:/getdrugs";
    }

    //跳转到更改页面
    @RequestMapping("/toupdate")
    public String toUpdate(Integer drId,Model model){
        List<Drug> dr = drugService.find(drId);
        model.addAttribute("dr", dr);
        return "medicine/update";
    }

    @RequestMapping("/update")
    public String update(Drug drug){
        Integer count = drugService.update(drug);
        return "redirect:/getdrugs";
    }

    //跳转到添加库存
    @RequestMapping("/toaddnum")
    public String toAddNum(Integer drId,Model model){
        List<Drug> dr = drugService.find(drId);
        model.addAttribute("dr", dr);
        return "medicine/add_medicine";
    }


    //修改库存
    @RequestMapping("/addnum")
    public String addNum(Drug drug){
        Integer count = drugService.addNum(drug);
        return "redirect:/getdrugs";
    }


    //跳转到详情页
    @RequestMapping("/tolook")
    public String toLook(Integer drId,Model model){
        List<Drug> dr = drugService.find(drId);
        model.addAttribute("dr", dr);
        return "medicine/look";
    }



    //查寻选中数据,导出excel
    @RequestMapping("/findids")
    public void findByIds(String ids, HttpServletResponse response){
        //查询选中
        List<Drug> drugs = drugService.findByIds(ids);
        //导出excel
        JavaExcelUtil.createFirst(new String[]{"药品的编号","药品图片URL","进价","售价","药品名称","药品类型",
                "简单介绍","保质期","详细描述","生产厂家","服用说明","备注","药品的库存","状态"});
        JavaExcelUtil.creatother(drugs);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String fmt = format.format(date);
        response.setContentType("application/x-download");
        String fileName = fmt+".xls";
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            JavaExcelUtil.export(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }










}
