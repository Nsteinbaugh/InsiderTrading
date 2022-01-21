package com.insidertrading.sec.api;

import com.insidertrading.sec.service.SECApiService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class SECApi {

    private SECApiService secApiService = new SECApiService();

    public HttpResponse<String> getLatest10Q() throws URISyntaxException, IOException, InterruptedException {
        return secApiService.getLatest10Q();
    }
}
