package com.github.youssfbr.cancerdemama.repositories;

import com.github.youssfbr.cancerdemama.entities.FaixaEtaria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFaixaEtariaRepository extends JpaRepository<FaixaEtaria, Long> {
}
