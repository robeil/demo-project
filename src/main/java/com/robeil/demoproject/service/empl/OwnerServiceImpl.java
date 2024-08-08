package com.robeil.demoproject.service.empl;

import com.robeil.demoproject.domain.Owner;
import com.robeil.demoproject.repository.OwnerRepository;
import com.robeil.demoproject.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);
    @Autowired
    private OwnerRepository repository;

    @Override
    public Optional<Owner> getOwnerById(long id) {
        var owner = repository.findById(id);
        if(owner.isEmpty()){
            logger.info("There is not owner with the id : {} " + id);

        }
        return owner;
    }

    @Override
    public List<Owner> getAllOwners() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return repository.findAllByOrderByFirstName(firstPageWithTwoElements);
    }

}
