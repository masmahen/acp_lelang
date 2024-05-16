package com.acp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acp.demo.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, String> {

}
