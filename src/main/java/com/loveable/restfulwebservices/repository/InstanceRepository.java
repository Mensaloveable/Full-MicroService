package com.loveable.restfulwebservices.repository;

import com.loveable.restfulwebservices.models.Instance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstanceRepository extends JpaRepository<Instance, Long> {
    Optional<Instance> findByEmail(String email);
}
