package com.zsx.pn.service.impl;

import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileServiceImp implements FileService {
    @Override
    public String uploadImage(MultipartFile file) {
        try {
            //文件名称
            String name = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + "_" + name + ".jpg";
            //src下文件目录路径
            String srcPath = "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "static" + File.separator +
                    "img" + File.separator +
                    fileName;
            //上传文件到src下对应目录
            copyFileToDirectory(file, srcPath);

            //target下文件目录路径
            String targetPath = "target" + File.separator +
                    "classes" + File.separator +
                    "static" + File.separator +
                    "img" + File.separator +
                    fileName;
            //上传文件到target下对应目录
            copyFileToDirectory(file, targetPath);

            //返回文件访问链接
            return "http://localhost:8080/api/img/" + fileName;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 拷贝文件
     * @param file
     * @param path
     * @throws IOException
     */
    private void copyFileToDirectory(MultipartFile file, String path) throws IOException {

        InputStream in = file.getInputStream();

        File outFile = new File(path);

        OutputStream out = new FileOutputStream(outFile);

        int temp = 0;

        byte[] data = new byte[2048];
        while ((temp = in.read(data)) != -1) {
            out.write(data, 0, temp);
        }

        out.close();
        in.close();
    }
}
