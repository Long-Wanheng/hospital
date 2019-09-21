package com.agoi.utils;

import com.agoi.pojo.Drug;
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
public class JavaExcelUtil {
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
            Drug drug = (Drug) list.get(i);

            row.createCell(0).setCellValue(drug.getDrId());
            row.createCell(1).setCellValue(drug.getDrUrl());
            row.createCell(2).setCellValue(drug.getDrInprice());
            row.createCell(3).setCellValue(drug.getDrOutprice());
            row.createCell(4).setCellValue(drug.getDrName());
            row.createCell(5).setCellValue(drug.getDrugStatus().getStatusName());
            row.createCell(6).setCellValue(drug.getDrSimDesc());
            row.createCell(7).setCellValue(drug.getDrTime());
            row.createCell(8).setCellValue(drug.getDrDetaDesc());
            row.createCell(9).setCellValue(drug.getdrFactory());
            row.createCell(10).setCellValue(drug.getDrDirection());
            row.createCell(11).setCellValue(drug.getDrRemark());
            row.createCell(12).setCellValue(drug.getDrNumber());
            row.createCell(13).setCellValue(drug.getDrStatusMap());

//            row.createCell(4).setCellValue(drug.getHosrState()==0?"已挂号":drug.getHosrState()==1?"已住院":drug.getHosrState()==2?"已出院":drug.getHosrState()==3?"已退号":"");

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
