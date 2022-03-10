package com.github.youssfbr.cancerdemama.repositories;

import com.github.youssfbr.cancerdemama.entities.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegiaoRepository extends JpaRepository<Regiao, Long> {
}
