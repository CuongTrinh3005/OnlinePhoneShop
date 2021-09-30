package com.example.onlinephoneshop.entity;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="manufactuters")
public class Manufacturer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;

    @Column
    @NotBlank
    private String manufacturerName;

    @Column
    @Email
    private String email;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String country;
}
