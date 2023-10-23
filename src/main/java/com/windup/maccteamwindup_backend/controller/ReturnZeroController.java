package com.windup.maccteamwindup_backend.controller;

import com.windup.maccteamwindup_backend.service.ReturnZeroServicev2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ReturnZeroController {
    private final ReturnZeroServicev2 returnZeroServicev2;
    @PostMapping("/authenticate")
    public String auth() throws IOException {
        return returnZeroServicev2.auth();
    }
    @PostMapping("/transcribe")
    public String setTranscribe(String jwtToken, MultipartFile file) throws IOException {
        String trans = returnZeroServicev2.setTranscribe(jwtToken, file);
        return trans;
    }
    @PostMapping("/transcribe/{transId}")
    public String getTranscribe(String jwt, @PathVariable String transId) throws IOException {
        return returnZeroServicev2.getTranscribe(jwt,transId);
    }
}
