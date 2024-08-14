package com.robeil.demoproject;

import com.robeil.demoproject.domain.Owner;
import com.robeil.demoproject.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository repository;

    @Test
    void saveOwner(){
        repository.save(new Owner("Lucy","Smith"));
        assertThat(
                repository.findByFirstName("Lucy").isPresent()
        ).isTrue();
    }

    @Test
    void deleteOwners(){
        repository.save(new Owner("Lisa","Robeil"));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}
