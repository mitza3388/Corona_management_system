package com.Spring.Spring.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "id", unique = true)
    @NotNull(message = "Must provide id")
    @Digits(integer = 9, message = "Id must have 9 digits", fraction = 0)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "Must provide first name")
    @Size(max = 45, message = "first name can be 45 characters maximum")
    private String first_name;

    @Column(name = "last_name")
    @NotBlank(message = "Must provide last name")
    @Size(max = 45, message = "last name can be 45 characters maximum")
    private String last_name;

    @Column(name = "city")
    @Size(max = 45, message = "city can be 45 characters maximum")
    private String city;

    @Column(name = "street")
    @Size(max = 45, message = "street can be 45 characters maximum")
    private String street;

    @Column(name = "street_number")
    private int street_number;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "phone")
    @Size(max = 45, message = "phone can be 45 characters maximum")
    private String phone;

    @Column(name = "mobile_phone")
    @Size(max = 10, min = 10, message = "mobile phone must be exactly 10 digits")
    private String mobile_phone;
}
