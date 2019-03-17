package com.astrazeneca.training.makerchecker.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString

@Entity
@Table(name="applications")

@NamedQuery(name="Application.findAll", query="SELECT app FROM Application app")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerid")
    private Long customerid;

    @Column(name="name")
    private String name ;

    @Column(name="emailid")
    private String emailid ;

    @Temporal(TemporalType.DATE)
    @Column(name="createddate")
    private Date createddate;

    @Temporal(TemporalType.DATE)
    @Column(name="modifieddate")
    private Date modifieddate;

    @Column(name="applicationtype")
    private String applicationtype;

    @Column(name="status")
    private String status;

}
