package com.deploy.ktp.repository;

import com.deploy.ktp.model.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KtpRepository extends JpaRepository<Ktp, Integer> {

    Optional<Ktp> findByNomorKtp(String nomorKtp);
    Optional<Ktp> findByNomorKtpAndIdNot(String nomorKtp, Integer id);
}