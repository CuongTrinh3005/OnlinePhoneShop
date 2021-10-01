package com.example.onlinephoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @Column(length = 8)
    private String categoryId;

    @Column(columnDefinition = "nvarchar", length = 30)
    private String categoryName;

    @Column(columnDefinition = "nvarchar")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products;
}
