package com.loveable.restfulwebservices.controller;

import com.loveable.restfulwebservices.dtos.InstanceDto;
import com.loveable.restfulwebservices.services.instance.InstanceServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstanceController {
    private final InstanceServices instanceServices;

    @PostMapping("/api/v1/instance")
    public ResponseEntity<InstanceDto> createInstance(@Valid @RequestBody InstanceDto instanceDto) {
        return ResponseEntity.ok(instanceServices.save(instanceDto));
    }

    @GetMapping("/api/v1/instance")
    public ResponseEntity<InstanceDto> getInstance(@Valid @RequestBody InstanceDto instanceDto) {
        return ResponseEntity.ok(instanceServices.getInstance(instanceDto));
    }

}
