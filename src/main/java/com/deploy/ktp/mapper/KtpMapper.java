package com.deploy.ktp.mapper;

import com.deploy.ktp.model.dto.KtpDto;
import com.deploy.ktp.model.entity.Ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KtpMapper {

    KtpMapper MAPPER = Mappers.getMapper(KtpMapper.class);

    KtpDto toDto(Ktp ktp);

}