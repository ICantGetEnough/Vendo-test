package com.example.vendotest.domain.entity;

import com.example.vendotest.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "user_details")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetail extends BaseEntity {
    @NotNull
    @Column(nullable = false)
    String firstName;

    @NotNull
    @Column(nullable = false)
    String lastName;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
