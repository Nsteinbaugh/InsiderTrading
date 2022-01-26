package com.insidertrading.sec.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filing {

    String id;
    String accessionNo;
    String cik;
    String ticker;
    String companyName;
    String companyNameLong;
    String formType;
    String description;
    String filedAt;
    String linkToHtml;
    String linkToFilingDetails;
    List<Entity> entities = new ArrayList<>();
}
