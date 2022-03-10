package com.github.youssfbr.cancerdemama.repositories;

import com.github.youssfbr.cancerdemama.entities.Incidencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidenciaRepository extends JpaRepository<Incidencia, Long> {
}
