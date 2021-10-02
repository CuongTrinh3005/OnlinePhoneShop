package com.example.onlinephoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brands")
public class Brand {
    @Id
    @Column(length = 8)
    private String brandId;

    @Column(columnDefinition = "nvarchar", length = 50)
    private String brandName;

    @Column(columnDefinition = "nvarchar", length = 20)
    private String country;

    @Column(columnDefinition = "nvarchar")
    private String description;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products;
}
