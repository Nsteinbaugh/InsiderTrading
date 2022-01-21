package com.insidertrading.sec.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SECApiService {

    private static String apiKey = "30ce744ac9821289b51f9185573c748b1d0880d3d8a0cae6b6ffdf0545ee96ca";

    private static String baseUrl = "https://api.sec-api.io";

    public HttpResponse<String> getLatest10Q() throws URISyntaxException, IOException, InterruptedException {

        String requestBody = "{ \"query\": {\"query_string\": " +
                "{\"query\": \"formType:\"10-Q\"\"}}, " +
                "\"from\": \"0\"," +
                "\"size\": \"10\"," +
                "\"sort\": [ { \"filedAt\": { \"order\": \"desc\"}}]}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
