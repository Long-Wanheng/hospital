package com.agoi.utils;

import com.agoi.pojo.HosRegister;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: agoi
 * @date 2019/09/19 11:05
 */
public class ExcelUtil {
    //1.创建一个excel文件
    static HSSFWorkbook hssfWorkbook;

    //2.创建sheet文件
    static HSSFSheet hssfSheet;

    //3.设置头信息(excel第一行数据)
    static String[] heads;

    //4.创建第一行信息
    public static void createFirst(String[] h){
        //创建工作簿
        hssfWorkbook = new HSSFWorkbook();
        //创建sheet文件
        hssfSheet = hssfWorkbook.createSheet("导出信息");
        //创建第一行的信息,参数是行下标,行的下标是从0开始的
        HSSFRow row = hssfSheet.createRow(0);
        heads = h;
        //给第一行创建列
        for (int i=0;i<heads.length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(heads[i]);
        }
    }

    //5.创建第二行以后的数据
    public static void creatother(List list){
        for (int i=0;i<list.size();i++){
           HSSFRow row = hssfSheet.createRow(i+1);
           HosRegister hosRegister = (HosRegister) list.get(i);
            HSSFCell c1 = row.createCell(0);
            c1.setCellValue(hosRegister.getHosrId());

            HSSFCell c2 = row.createCell(1);
            c2.setCellValue(hosRegister.getDoctor().getdDoctorName());

            HSSFCell c3 = row.createCell(2);
            c3.setCellValue(hosRegister.getHosdate());

            HSSFCell c4 = row.createCell(3);
            c4.setCellValue(hosRegister.getDept().getDname());

            HSSFCell c5 = row.createCell(4);
            c5.setCellValue(hosRegister.getHosrState()==0?"已挂号":hosRegister.getHosrState()==1?"已住院":hosRegister.getHosrState()==2?"已出院":hosRegister.getHosrState()==3?"已退号":"");

        }
    }

    //6.导出
    public static void export(OutputStream outputStream){
        //设置导出时使用的表格方式导出
        hssfSheet.setGridsPrinted(true);
        try {
            hssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
