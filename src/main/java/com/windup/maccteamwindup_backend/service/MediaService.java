//package com.windup.maccteamwindup_backend.service;
//
//import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//@Service
//public class MediaService {
//    @Value("${audio-dir}")
//    private String uploadDir;
//
//    public void fileUpload(MultipartFile multipartFile) {
//        Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
//        try {
//            Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
