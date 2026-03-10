package com.deploy.ktp.service;

import com.deploy.ktp.model.dto.KtpAddRequest;
import com.deploy.ktp.model.dto.KtpDto;

import java.util.List;

public interface KtpService {

    KtpDto addKtp(KtpAddRequest request);

    List<KtpDto> getAll();

    KtpDto getById(Integer id);

    KtpDto update(Integer id, KtpAddRequest request);

    void delete(Integer id);

}