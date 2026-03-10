package com.deploy.ktp.controller;

import com.deploy.ktp.model.dto.KtpAddRequest;
import com.deploy.ktp.model.dto.KtpDto;
import com.deploy.ktp.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public KtpDto add(@RequestBody KtpAddRequest request){
        return ktpService.addKtp(request);
    }

    @GetMapping
    public List<KtpDto> getAll(){
        return ktpService.getAll();
    }

    @GetMapping("/{id}")
    public KtpDto getById(@PathVariable Integer id){
        return ktpService.getById(id);
    }

    @PutMapping("/{id}")
    public KtpDto update(@PathVariable Integer id, @RequestBody KtpAddRequest request){
        return ktpService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ktpService.delete(id);
    }
}