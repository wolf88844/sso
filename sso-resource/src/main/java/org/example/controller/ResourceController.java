package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @PreAuthorize("hasAuthority('sys:res:list')")
    @GetMapping
    public String doSelect(){
        return "Select Resource ok";
    }

    @PreAuthorize(("hasAuthority('sys:res:create')"))
    @PostMapping
    public String doCreate(){
        return "Create Resource ok";
    }

    @PreAuthorize(("hasAuthority('sys:res:update')"))
    @PutMapping
    public String doUpdate(){
        return "Update Resource ok";
    }

    @DeleteMapping
    public String doDelete(){
        return "Delete Resource ok";
    }
}
