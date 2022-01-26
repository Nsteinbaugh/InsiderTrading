package com.insidertrading.sec.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insidertrading.sec.response.Form4Response;
import com.insidertrading.sec.response.Latest10QResponse;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SECApiService {

    private static String apiKey = "30ce744ac9821289b51f9185573c748b1d0880d3d8a0cae6b6ffdf0545ee96ca";

    private static String baseUrl = "https://api.sec-api.io";

    public Latest10QResponse getLatest10Q() throws URISyntaxException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String queryString = "formType:\"10-Q\"";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(baseUrl))
            .header("Content-Type", "application/json")
            .header("Authorization", apiKey)
            .POST(HttpRequest.BodyPublishers.ofString(buildQueryAPIRequestBody(queryString, "0", "10", "desc").toString()))
            .build();

        String responseBody = HttpClient.newBuilder()
            .build()
            .send(request, HttpResponse.BodyHandlers.ofString()).body();

        return objectMapper.readValue(responseBody, Latest10QResponse.class);
    }

    public Form4Response getForm4(String ticker) throws URISyntaxException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String queryString = "ticker:" + ticker + " AND formType:4 AND formType:(NOT \"N-4\") AND formType:(NOT \"4/A\")";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(baseUrl))
            .header("Content-Type", "application/json")
            .header("Authorization", apiKey)
            .POST(HttpRequest.BodyPublishers.ofString(buildQueryAPIRequestBody(queryString, "0", "10", "desc").toString()))
            .build();

        String responseBody = HttpClient.newBuilder()
            .build()
            .send(request, HttpResponse.BodyHandlers.ofString()).body();
        return objectMapper.readValue(responseBody, Form4Response.class);
    }


    private JsonObject buildQueryAPIRequestBody(String queryString, String from, String size, String sortOrder) {
        return Json.createObjectBuilder()
                .add("query", Json.createObjectBuilder()
                        .add("query_string", Json.createObjectBuilder()
                                .add("query", queryString)))
                .add("from", from)
                .add("size", size)
                .add("sort", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("filedAt", Json.createObjectBuilder()
                                        .add("order", sortOrder)))).build();
    }
}
