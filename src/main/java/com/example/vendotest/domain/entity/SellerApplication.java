package com.example.vendotest.domain.entity;

import com.example.vendotest.domain.entity.base.BaseEntity;
import com.example.vendotest.domain.enums.ApplicationStatus;
import com.example.vendotest.domain.enums.CompanyType;
import com.example.vendotest.domain.enums.Country;
import com.example.vendotest.domain.enums.ProductCategory;
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
@Table(name = "application_forms",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "emailAddress"),
                @UniqueConstraint(columnNames = "mobilePhone"),
                @UniqueConstraint(columnNames = "tin"),
                @UniqueConstraint(columnNames = "referenceCode")
        })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerApplication extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    String companyName;

    @Email
    @Column(nullable = false)
    String emailAddress;

    @NotNull
    @Column(nullable = false)
    String mobilePhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CompanyType companyType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProductCategory productCategory;

    @NotNull
    @Column(nullable = false)
    String tin;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    boolean tinVerified = false;

    @NotNull
    @Column(nullable = false)
    String province;

    @NotNull
    @Column(nullable = false)
    String district;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Country country;

    @Enumerated(EnumType.STRING)
    Country detectedCountry; // авто-детект по IP или геолокации

    @NotNull
    @Column(nullable = false)
    String referenceCode;

    @OneToOne(mappedBy = "sellerApplication")
    User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false)
    ApplicationStatus applicationStatus = ApplicationStatus.PENDING_TIN_VERIFICATION;

}
