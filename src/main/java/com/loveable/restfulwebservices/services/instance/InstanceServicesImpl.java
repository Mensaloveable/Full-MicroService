package com.loveable.restfulwebservices.services.instance;

import com.loveable.restfulwebservices.dtos.InstanceDto;
import com.loveable.restfulwebservices.exception.InstanceAlreadyExistException;
import com.loveable.restfulwebservices.exception.InstanceNotFoundException;
import com.loveable.restfulwebservices.models.Instance;
import com.loveable.restfulwebservices.repository.InstanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstanceServicesImpl implements InstanceServices {

    private final InstanceRepository instanceRepository;
    private final ModelMapper mapper;

    @Override
    public InstanceDto save(InstanceDto instanceDto) {

        Optional<Instance> optionalInstance = instanceRepository.findByEmail(instanceDto.getEmail());

        if (optionalInstance.isPresent()) {
            throw new InstanceAlreadyExistException("Email Already Exist. Try forget-password or use a different email");
        }

        instanceDto.setLastSeen(new Date());
        Instance instance = mapper.map(instanceDto, Instance.class);
        Instance savedInstance = instanceRepository.save(instance);

        savedInstance.setPassword(null);

        return mapper.map(savedInstance, InstanceDto.class);
    }

    @Override
    public InstanceDto getInstance(InstanceDto instanceDto) {

        Optional<Instance> optionalInstance = instanceRepository.findByEmail(instanceDto.getEmail());

        if (optionalInstance.isEmpty()) {
            throw new InstanceNotFoundException("Invalid Email or Password");
        }

        Instance instance = optionalInstance.get();
        instance.setPassword(null);

        return mapper.map(instance, InstanceDto.class);
    }

    @Override
    public List<InstanceDto> getAllInstances() {

        List<Instance> allUsers = instanceRepository.findAll();

        return allUsers.stream()
                .map(instance -> {
                    instance.setPassword(null);
                    return mapper.map(instance, InstanceDto.class);
                })
                .toList();
    }
}
