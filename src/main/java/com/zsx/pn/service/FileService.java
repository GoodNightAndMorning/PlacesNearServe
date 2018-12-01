package com.zsx.pn.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传图片
     * @param file
     * @return 图片url
     */
    String uploadImage(MultipartFile file);
}
