package com.demp.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Slf4j
@Component
public class Upload {

    public static String imageType = ".jpg";

    public static String successMsg = "上传成功";

    public static String errorMsg = "上传失败";

    private static ResourceLoader loader;

    private static HttpServletRequest request;

    @Autowired
    public Upload(ResourceLoader resourceLoader , HttpServletRequest request2) {
        loader = resourceLoader;
        request = request2;
    }

    public static String uploadFile(String path , MultipartFile file) {
        return uploadFile(path , file , "");
    }

    public static String uploadFile(MultipartFile file ,  String name) {
        return uploadFile(null , file , name);
    }

    public static String uploadFile(String path , MultipartFile file , String name) {
        if(file.isEmpty()) {
            return errorMsg + ": 文件为空";
        }

        try {
            Path uploadDir = getUploadDir(path==null?"" : path);
            Path destinationPath = null;
            if(name == null) {
                destinationPath = uploadDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            }
           else destinationPath = uploadDir.resolve(name + imageType);
            Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return successMsg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        String scheme = request.getScheme(); // http
        String serverName = request.getServerName(); // localhost
        int serverPort = request.getServerPort(); // 9090
        return scheme + "://" + serverName + ":" + serverPort;
    }


    public static void deleteFile(String uri) throws IOException {
        String url = getBaseUrl() + "/";
        String path = uri.substring(url.length() - 1);
        Path p = Paths.get(getUploadDir("/") + path);
        Files.delete(p);
        log.info("文件删除成功");
    }

    public static Path getUploadDir(String path) throws IOException {
        return Paths.get(loader.getResource("classpath:static" + path).getURI());
    }


}
