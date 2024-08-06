package com.robeil.demoproject.service;

import com.robeil.demoproject.domain.Owner;

import java.util.Optional;

public interface OwnerService {

    Optional<Owner> getOwnerById(long id);
}
