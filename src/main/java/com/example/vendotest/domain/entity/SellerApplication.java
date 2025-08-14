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
    private String companyName;

    @Email
    @Column(nullable = false)
    private String emailAddress;

    @NotNull
    @Column(nullable = false)
    private String mobilePhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyType companyType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory productCategory;

    @NotNull
    @Column(nullable = false)
    private String tin;

    @NotNull
    @Column(nullable = false)
    private boolean tinVerified = false;

    @NotNull
    @Column(nullable = false)
    private String province;

    @NotNull
    @Column(nullable = false)
    private String district;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Country country;

    @NotNull
    @Column(nullable = false)
    private String referenceCode;

    @OneToOne(mappedBy = "applicationForm")
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus applicationStatus = ApplicationStatus.PENDING_TIN_VERIFICATION;

}
