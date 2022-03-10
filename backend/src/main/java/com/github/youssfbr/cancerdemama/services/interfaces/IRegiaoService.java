package com.github.youssfbr.cancerdemama.services.interfaces;

import com.github.youssfbr.cancerdemama.entities.Regiao;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;

import java.util.List;

public interface IRegiaoService {

    List<Regiao> findAll();
    Regiao findById(final Long id) throws EntityNotFoundException;
    void createRegiao(final Regiao regiao);
    void updateRegiao(final long id, final Regiao regiao) throws EntityNotFoundException;
    void delete(final Long id) throws EntityNotFoundException;

}
