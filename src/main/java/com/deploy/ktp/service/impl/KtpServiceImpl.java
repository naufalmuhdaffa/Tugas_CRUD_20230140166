package com.deploy.ktp.service.impl;

import com.deploy.ktp.mapper.KtpMapper;
import com.deploy.ktp.model.dto.KtpAddRequest;
import com.deploy.ktp.model.dto.KtpDto;
import com.deploy.ktp.model.entity.Ktp;
import com.deploy.ktp.repository.KtpRepository;
import com.deploy.ktp.service.KtpService;
import com.deploy.ktp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public KtpDto addKtp(KtpAddRequest request) {
        validationUtil.validate(request);

        if(ktpRepository.findByNomorKtp(request.getNomorKtp()).isPresent()){
            throw new RuntimeException("Nomor KTP sudah ada");
        }

        Ktp ktp = Ktp.builder()
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(ktp);

        return KtpMapper.MAPPER.toDto(ktp);
    }

    @Override
    public List<KtpDto> getAll() {

        List<Ktp> list = ktpRepository.findAll();
        List<KtpDto> result = new ArrayList<>();

        for(Ktp k : list){
            result.add(KtpMapper.MAPPER.toDto(k));
        }

        return result;
    }

    @Override
    public KtpDto getById(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return KtpMapper.MAPPER.toDto(ktp);
    }

    @Override
    public KtpDto update(Integer id, KtpAddRequest request) {
        validationUtil.validate(request);

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());

        ktpRepository.save(ktp);

        return KtpMapper.MAPPER.toDto(ktp);
    }

    @Override
    public void delete(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktpRepository.delete(ktp);
    }
}