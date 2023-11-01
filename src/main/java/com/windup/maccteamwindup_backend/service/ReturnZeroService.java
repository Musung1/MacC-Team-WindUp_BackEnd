//package com.windup.maccteamwindup_backend.service;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.windup.maccteamwindup_backend.dto.RzAuthDTO;
//import com.windup.maccteamwindup_backend.dto.RzIdDTO;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.util.Scanner;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class ReturnZeroService {
//    @Value("${return-zero-api-id}")
//    private String apiId;
//    @Value("${return-zero-api-secret}")
//    private String apiSecret;
//    @Async
//    public CompletableFuture<String> auth() throws IOException {
//        URL url = new URL("https://openapi.vito.ai/v1/authenticate");
//        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        httpConn.setRequestMethod("POST");
//        httpConn.setRequestProperty("accept", "application/json");
//        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        httpConn.setDoOutput(true);
//
//        String data = String.format("client_id=%s&client_secret=%s",apiId,apiSecret);
//
//        byte[] out = data.getBytes(StandardCharsets.UTF_8);
//
//        OutputStream stream = httpConn.getOutputStream();
//        stream.write(out);
//
//        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
//                ? httpConn.getInputStream()
//                : httpConn.getErrorStream();
//        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
//        String response = s.hasNext() ? s.next() : "";
//        s.close();
//        ObjectMapper objectMapper = new ObjectMapper();
//        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        RzAuthDTO rzAuth = objectMapper.readValue(response, RzAuthDTO.class);
//        return CompletableFuture.completedFuture(rzAuth.getAccess_token());
//    }
//    public CompletableFuture<String> setTranscribe(String token) throws IOException {
//        URL url = new URL("https://openapi.vito.ai/v1/transcribe");
//        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        httpConn.setRequestMethod("POST");
//        httpConn.setRequestProperty("accept", "application/json");
//        httpConn.setRequestProperty("Authorization", "Bearer "+ token);
//        httpConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=authsample");
//        httpConn.setDoOutput(true);
//
//        File file = new File("/Users/musung/documents/HighPitch/Audio/test.m4a");
//
//        DataOutputStream outputStream;
//        outputStream = new DataOutputStream(httpConn.getOutputStream());
//
//        outputStream.writeBytes("--authsample\r\n");
//        outputStream.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + file.getName() +"\"\r\n");
//        outputStream.writeBytes("Content-Type: " + URLConnection.guessContentTypeFromName(file.getName()) + "\r\n");
//        outputStream.writeBytes("Content-Transfer-Encoding: binary" + "\r\n");
//        outputStream.writeBytes("\r\n");
//
//        FileInputStream in =new FileInputStream(file);
//        byte[] buffer = new byte[(int)file.length()];
//        int bytesRead = -1;
//        while ((bytesRead = in.read(buffer)) != -1) {
//            outputStream.write(buffer,0,bytesRead);
//            outputStream.writeBytes("\r\n");
//            outputStream.writeBytes("--authsample\r\n");
//        }
//        outputStream.writeBytes("\r\n");
//        outputStream.writeBytes("--authsample\r\n");
//        outputStream.writeBytes("Content-Disposition: form-data; name=\"config\"\r\n");
//        outputStream.writeBytes("Content-Type: application/json\r\n");
//        outputStream.writeBytes("\r\n");
//        outputStream.writeBytes("{}");
//        outputStream.writeBytes("\r\n");
//        outputStream.writeBytes("--authsample\r\n");
//        outputStream.flush();
//        outputStream.close();
//
//        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
//                ? httpConn.getInputStream()
//                : httpConn.getErrorStream();
//        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
//        String response = s.hasNext() ? s.next() : "";
//        s.close();
//        ObjectMapper objectMapper = new ObjectMapper();
//        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        RzIdDTO rzIdDTO = objectMapper.readValue(response, RzIdDTO.class);
//        return CompletableFuture.completedFuture(rzIdDTO.getId());
//    }
//    public void getTranscribe(String jwt, String id) throws IOException {
//        URL url = new URL("https://openapi.vito.ai/v1/transcribe/"+id);
//        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        httpConn.setRequestMethod("GET");
//        httpConn.setRequestProperty("accept", "application/json");
//        httpConn.setRequestProperty("Authorization", "Bearer " + jwt);
//
//        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
//                ? httpConn.getInputStream()
//                : httpConn.getErrorStream();
//        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
//        String response = s.hasNext() ? s.next() : "";
//        s.close();
//    }
//
//}
