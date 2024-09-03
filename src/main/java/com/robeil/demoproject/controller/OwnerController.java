package com.robeil.demoproject.controller;

import com.robeil.demoproject.domain.Owner;
import com.robeil.demoproject.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;
    @GetMapping("/{ownerId}")
    public Optional<Owner> getOwnerById(@PathVariable int ownerId){
        return service.getOwnerById(ownerId);
    }
    @GetMapping
    public List<Owner> getAllOwners(){
        return service.getAllOwners();
    }

}
