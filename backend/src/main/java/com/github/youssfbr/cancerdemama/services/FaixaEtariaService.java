package com.github.youssfbr.cancerdemama.services;

import com.github.youssfbr.cancerdemama.entities.FaixaEtaria;
import com.github.youssfbr.cancerdemama.repositories.IFaixaEtariaRepository;
import com.github.youssfbr.cancerdemama.services.exceptions.DatabaseException;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.exceptions.InternalServerError;
import com.github.youssfbr.cancerdemama.services.interfaces.IFaixaEtariaService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FaixaEtariaService implements IFaixaEtariaService {

    private final IFaixaEtariaRepository faixaEtariaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<FaixaEtaria> findAll() {
        return faixaEtariaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FaixaEtaria findById(final Long id) throws EntityNotFoundException {
        return faixaEtariaRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public void createFaixaEtaria(FaixaEtaria faixaEtaria) {
        faixaEtariaRepository.save(faixaEtaria);
    }

    @Override
    public void updateFaixaEtaria(long id, FaixaEtaria faixaEtaria) throws EntityNotFoundException {

        FaixaEtaria faixaEtariaExiste = this.findById(id);
        faixaEtaria.setId(faixaEtariaExiste.getId());

        faixaEtariaRepository.save(faixaEtaria);
    }

    @Override
    public void delete(final Long id) throws EntityNotFoundException {
        try {
            faixaEtariaRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não foi possível excluir. Violação de integridade.", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new InternalServerError("Erro interno. Por favor entrar em contato com o suporte.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
