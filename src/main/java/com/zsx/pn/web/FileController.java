package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.service.FileService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    public BaseDto uploadImage(@Param("file") MultipartFile file){
        try {
            String path = fileService.uploadImage(file);

            return BaseResult.success(path, "上传图片成功");

        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }

    }
}
