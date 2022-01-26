package com.insidertrading.sec.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    String companyName;
    String cik;
    String irsNo;
    String stateOfIncorporation;
    String fiscalYearEnd;
    String type;
    String act;
    String fileNo;
    String filmNo;
    String sic;

}
