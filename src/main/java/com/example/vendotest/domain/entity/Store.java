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
@Table(name = "stores")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store extends BaseEntity {
    @NotNull
    @Column(nullable = false)
    String brandName;

    @Lob
    String brandDescription;

    String coverPhotoPath; // путь к файлу на сервере

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
