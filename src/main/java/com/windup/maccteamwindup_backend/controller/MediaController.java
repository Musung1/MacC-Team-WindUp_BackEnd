package com.windup.maccteamwindup_backend.controller;

import com.windup.maccteamwindup_backend.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;

    @PostMapping("/upload")
    public void fileUpload(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) {
        mediaService.fileUpload(file);
    }
}
