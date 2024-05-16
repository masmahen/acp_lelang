package com.acp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acp.demo.entity.DokumenEntity;

public interface DokumenRepository extends JpaRepository<DokumenEntity, Long> {

}
