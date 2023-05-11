package com.Spring.Spring.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corona_info")
public class CoronaPatInfo {

    @Id
    @Column(name = "id")
    @NotNull(message = "Must provide id")
    @Digits(integer = 9, message = "Id must have 9 digits", fraction = 0)
    private Long id;

    @Column(name = "vac_date_1")
    private Date vac_date_1;

    @Column(name = "vac_man_1")
    private String vac_man_1;

    @Column(name = "vac_date_2")
    private Date vac_date_2;

    @Column(name = "vac_man_2")
    private String vac_man_2;

    @Column(name = "vac_date_3")
    private Date vac_date_3;

    @Column(name = "vac_man_3")
    private String vac_man_3;

    @Column(name = "vac_date_4")
    private Date vac_date_4;

    @Column(name = "vac_man_4")
    private String vac_man_4;

    @Column(name = "positive_date")
    private Date positive_date;

    @Column(name = "recovery_date")
    private Date recovery_date;
}
