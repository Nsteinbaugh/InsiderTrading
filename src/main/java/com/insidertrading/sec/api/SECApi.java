package com.insidertrading.sec.api;

import com.insidertrading.sec.response.Form4Response;
import com.insidertrading.sec.response.Latest10QResponse;
import com.insidertrading.sec.service.SECApiService;

import java.io.IOException;
import java.net.URISyntaxException;

public class SECApi {

    private SECApiService secApiService = new SECApiService();

    public Latest10QResponse getLatest10Q() throws URISyntaxException, IOException, InterruptedException {
        return secApiService.getLatest10Q();
    }

    public Form4Response getForm4(String ticker) throws URISyntaxException, IOException, InterruptedException {
        return secApiService.getForm4(ticker);
    }
}
