package com.windup.maccteamwindup_backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReturnZeroServicev2Test {
    private ReturnZeroServicev2 returnZeroServicev2;

    public ReturnZeroServicev2Test(@Autowired ReturnZeroServicev2 returnZeroServicev2) {
        this.returnZeroServicev2 = returnZeroServicev2;
    }

    @Test
    public void hello(){
        //returnZeroServicev2.setTranscribe();
    }

}