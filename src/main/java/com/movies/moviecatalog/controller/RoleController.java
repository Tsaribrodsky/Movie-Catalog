package com.movies.moviecatalog.controller;

import com.movies.moviecatalog.model.Role;
import com.movies.moviecatalog.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> list(){
        return roleRepository.findAll();
    }

    @GetMapping("/{roleId}")
    public Role get(@PathVariable Long roleId){
        return roleRepository.getById(roleId);
    }

    @PostMapping
    public Role create(@RequestBody final Role role){
        return roleRepository.save(role);
    }

    @DeleteMapping("/{roleId}")
    public void delete(@PathVariable Long roleId){
        roleRepository.deleteById(roleId);
    }

    @PutMapping("/{roleId}")
    public Role update(@PathVariable Long roleId, @RequestBody Role role){
        Role existingRole = roleRepository.getById(roleId);
        BeanUtils.copyProperties(role, existingRole, "roleId");
        return roleRepository.save(existingRole);
    }
}
