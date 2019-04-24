package com.bw.controller;


import com.alibaba.fastjson.JSONObject;
import com.bw.api.BitcoinApi;
import com.bw.api.BitcoinJsonRpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;


    @GetMapping("/test")
    public void test() throws Throwable {
        String txid = "c5150b50caa848cda9b08d7bc162d90bcdaf91bbbc2fa9722409630980b39722";
        JSONObject rawTransaxtion = bitcoinJsonRpcClient.getRawTransaxtion(txid);
    }
}
