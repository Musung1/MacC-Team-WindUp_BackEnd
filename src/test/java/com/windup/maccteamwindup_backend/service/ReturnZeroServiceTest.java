package com.windup.maccteamwindup_backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
class ReturnZeroServiceTest {
    private final ReturnZeroService returnZeroService;

    ReturnZeroServiceTest(@Autowired ReturnZeroService returnZeroService) {

        this.returnZeroService = returnZeroService;
    }

    @Test
    public void authTest() throws IOException {
        CompletableFuture<String> token = returnZeroService.auth();
        String sToken = token.join();
        CompletableFuture<String> id = returnZeroService.setTranscribe(sToken);
        String sId = id.join();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        returnZeroService.getTranscribe(sToken,sId);
    }

}