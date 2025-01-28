package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
