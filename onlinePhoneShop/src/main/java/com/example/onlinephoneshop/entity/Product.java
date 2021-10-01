package com.example.onlinephoneshop.entity;

import com.example.onlinephoneshop.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Entity(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorFormula("case when imeiNo is not null then 1 else 2 end")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditModel {
    @Id
    @Column
    @GeneratedValue(generator = "phoneid-generator")
    @GenericGenerator(name = "phoneid-generator",
            parameters = @Parameter(name = "prefix", value = "PD"),
            strategy = "com.example.onlinephoneshop.generators.PhoneIdGenerator")
    private String productId;

    @Column
    @NotBlank
    private String productName;

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
    @DecimalMin(value = "0", message ="Number of month in warranty must greater than 0")
    private Integer warranty;

    @Column
    private Float label;

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

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Rating> ratings;
}
