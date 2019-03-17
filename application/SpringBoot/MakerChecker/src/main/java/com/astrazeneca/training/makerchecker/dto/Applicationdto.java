package com.astrazeneca.training.makerchecker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Applicationdto {

    private Long customerid;

    private String name ;

    private String emailid ;

    private Date createddate;

    private Date modifieddate;

    private String applicationtype;

    private String status;

}
