package com.robeil.demoproject.service;

import com.robeil.demoproject.domain.Owner;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Optional<Owner> getOwnerById(long id);
    List<Owner> getAllOwners();

}
