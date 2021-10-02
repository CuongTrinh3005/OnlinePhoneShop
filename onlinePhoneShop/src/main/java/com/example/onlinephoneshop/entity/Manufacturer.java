package com.example.onlinephoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

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

    @Column(columnDefinition = "nvarchar", length = 50)
    @NotBlank
    private String manufacturerName;

    @Column
    @Email
    private String email;

    @Column(columnDefinition = "nvarchar")
    private String address;

    @Column
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar", length = 20)
    private String country;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products;
}
