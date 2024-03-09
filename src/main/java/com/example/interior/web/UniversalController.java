//package com.example.interior.web;
//
//import com.example.interior.web.dto.CMRespDto;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//@RestController
//@RequestMapping("/**") // 모든 요청을 처리합니다.
//public class UniversalController {
//
//    @Value("${server.env}")
//    private String env;
//    @Value("${server.port}")
//    private String serverPort;
//    @GetMapping
//    public CMRespDto<?> handleRequest() {
//        Map<String, String> responseData = new TreeMap<>();
//        responseData.put("serverPort", serverPort);
//        responseData.put("env", env);
//        return new CMRespDto<>(HttpStatus.OK.value(), "통신 성공",env);
//    }
//
//    @GetMapping("/health")
//    public CMRespDto<?> checkRequest() {
//        Map<String, String> responseData = new TreeMap<>();
//        responseData.put("serverPort", serverPort);
//        responseData.put("env", env);
//        return new CMRespDto<>(HttpStatus.OK.value(), "health checking complete",responseData);
//    }
//
//    @GetMapping("/env")
//    public CMRespDto<?> envRequest() {
//        return new CMRespDto<>(HttpStatus.OK.value(), ".env checking complete",env);
//    }
//
//}