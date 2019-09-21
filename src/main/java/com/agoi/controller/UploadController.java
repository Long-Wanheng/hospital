package com.agoi.controller;

import com.agoi.utils.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-21 15:36
 */
@RestController
@RequestMapping("/img")
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public ResultSet uploadImg(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultSet.view(-1, "文件不能为空");
        }
        String fileName = file.getOriginalFilename() + System.currentTimeMillis();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 文件上传路径
        String filePath = null;
        try {
            filePath = ResourceUtils.getURL("classpath:").getPath() + "userImg";
            File imgFile = new File(filePath + fileName);
            // 检测是否存在目录
            if (!imgFile.getParentFile().exists()) {
                imgFile.getParentFile().mkdirs();
            }
            file.transferTo(imgFile);
            //存入数据库文件名
            String dbFile = filePath + fileName + suffixName;
            //省略插入数据库代码
            LOGGER.info("文件上传成功！文件名:{},文件类型:{},文件路径:{},数据库文件名:{}", fileName, suffixName, filePath, dbFile);
            return ResultSet.view("上传成功");
        } catch (Exception e) {
            LOGGER.error("图片上传失败");
            return ResultSet.view(-1, "未知错误");
        }

    }
}
