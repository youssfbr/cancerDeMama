package com.github.youssfbr.cancerdemama.services.interfaces;

import com.github.youssfbr.cancerdemama.entities.FaixaEtaria;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;

import java.util.List;

public interface IFaixaEtariaService {

    List<FaixaEtaria> findAll();
    FaixaEtaria findById(final Long id) throws EntityNotFoundException;
    void createFaixaEtaria(final FaixaEtaria faixaEtaria);
    void updateFaixaEtaria(final long id, final FaixaEtaria faixaEtaria) throws EntityNotFoundException;
    void delete(final Long id) throws EntityNotFoundException;

}
