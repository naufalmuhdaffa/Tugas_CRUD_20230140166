package com.deploy.ktp.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KtpDto {

    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;
}