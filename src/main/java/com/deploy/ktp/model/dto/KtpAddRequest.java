package com.deploy.ktp.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class KtpAddRequest {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;
}