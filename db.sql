CREATE DATABASE IF NOT EXISTS spring;

USE spring;

CREATE TABLE IF NOT EXISTS ktp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomorKtp VARCHAR(16) UNIQUE,
    namaLengkap VARCHAR(255),
    alamat VARCHAR(255),
    tanggalLahir DATE,
    jenisKelamin VARCHAR(9)
);