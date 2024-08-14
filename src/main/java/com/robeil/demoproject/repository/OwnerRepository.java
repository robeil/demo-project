package com.robeil.demoproject.repository;

import com.robeil.demoproject.domain.Owner;
import com.robeil.demoproject.service.OwnerService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "owners")
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findAllByOrderByFirstName(Pageable pageable);
    Optional<Owner> findByFirstName(String firstName);
}
