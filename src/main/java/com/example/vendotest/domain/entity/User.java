package com.example.vendotest.domain.entity;


import com.example.vendotest.domain.entity.base.BaseEntity;
import com.example.vendotest.domain.enums.Language;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    String email;

    @NotNull
    @Column(nullable = false, unique = true)
    String phoneNumber;

    @NotNull
    @Column(nullable = false)
    String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language preferredLanguage;

    @OneToOne
    @JoinColumn(name = "seller_application_id")
    SellerApplication sellerApplication;
}
