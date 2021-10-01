package com.example.onlinephoneshop.entity;
import com.example.onlinephoneshop.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Parameter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends AuditModel{
    @Id
    @Column
    @GeneratedValue(generator = "userid-generator")
    @GenericGenerator(name = "userid-generator",
            parameters = @Parameter(name = "prefix", value = "US"),
            strategy = "com.example.onlinephoneshop.generators.UserIdGenerator")
    private String userId;

    @Column
    @NotNull
    private String username;

    @Column
    @NotBlank
    @JsonIgnore
    private String password;

    @Column(columnDefinition = "nvarchar", length = 40)
    @NotEmpty
    private String fullName;

    @Column
    @NotBlank
    @Email
    private String email;

    @Column
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar", length = 200)
    private String address;

    @Column
    private byte[] image;

    @Column
    private Boolean gender;

    @Column
    @Past
    private Date birthday;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

    public User(String userName, String fullName, String email, String password, String phoneNumber) {
        this.username = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
