package com.rims.drew.parsons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
