package com.loveable.restfulwebservices.services.instance;

import com.loveable.restfulwebservices.dtos.InstanceDto;

import java.util.List;

public interface InstanceServices {
    InstanceDto save(InstanceDto instanceDto);
    InstanceDto getInstance(InstanceDto instanceDto);
    List<InstanceDto> getAllInstances();
}
