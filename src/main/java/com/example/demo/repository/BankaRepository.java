package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Banka;

public interface BankaRepository extends JpaRepository<Banka, Long> {

}
