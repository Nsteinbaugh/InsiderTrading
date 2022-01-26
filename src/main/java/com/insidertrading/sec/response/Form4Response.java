package com.insidertrading.sec.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.insidertrading.sec.domain.Filing;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form4Response {

    HashMap<String, Object> total;
    HashMap<String, Object> query;
    List<Filing> filings = new ArrayList<>();
}
