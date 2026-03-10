package com.deploy.ktp.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ktp")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nomorKtp;

    private String namaLengkap;

    private String alamat;

    private Date tanggalLahir;

    private String jenisKelamin;
}