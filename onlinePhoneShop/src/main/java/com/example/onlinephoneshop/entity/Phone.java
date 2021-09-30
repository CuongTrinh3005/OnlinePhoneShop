package com.example.onlinephoneshop.entity;

import com.example.onlinephoneshop.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phones")
public class Phone extends AuditModel {
    @Id
    @Column
    @GeneratedValue(generator = "phoneid-generator")
    @GenericGenerator(name = "phoneid-generator",
            parameters = @Parameter(name = "prefix", value = "PD"),
            strategy = "com.example.onlinephoneshop.generators.PhoneIdGenerator")
    private String phoneId;

    @Column
    @NotBlank
    private String phoneName;

    @Column
    @DecimalMin(value = "0", message = "Price must be not under 0")
    private Float unitPrice;

    @Column
    @DecimalMin(value = "0", message = "Quantity must be not under 0")
    private Long quantity;

    @Column
    @DecimalMin(value = "0", message = "Discount must be not under 0%")
    @DecimalMax(value = "0.7", message = "Discount must be not over 70%")
    private Float discount;

    @Column
    private byte[] image;

    @Column
    private String description;

    @Column
    private String specification;

    @Column
    @DecimalMin(value = "0", message = "No. view must be not under 0")
    private Long viewCount;

    @Column
    private Boolean special;

    @Column
    private Boolean available;

    @Column
    @NaturalId
    private String model;

    @Column
    @NaturalId
    @Size(min = 15, max = 15)
    private String imeiNo;

    @Column
    @DecimalMin(value = "0", message ="Number of month in warranty must greater than 0")
    private Integer warranty;

    // Specify entity relationships
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name = "manufacturerId")
    @JsonIgnore
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "brandId")
    @JsonIgnore
    private Brand brand;

    @OneToMany(mappedBy = "phone", fetch = FetchType.EAGER)
    private Set<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "phone", fetch = FetchType.EAGER)
    private Set<Rating> ratings;
}
