package com.example.onlinephoneshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accessory extends Product{
    @Column
    private String compatibleDevices;

    @Column
    private String functions;
}