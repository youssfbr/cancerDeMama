package com.github.youssfbr.cancerdemama.services;

import com.github.youssfbr.cancerdemama.entities.Regiao;
import com.github.youssfbr.cancerdemama.repositories.IRegiaoRepository;
import com.github.youssfbr.cancerdemama.services.exceptions.DatabaseException;
import com.github.youssfbr.cancerdemama.services.exceptions.InternalServerError;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.interfaces.IRegiaoService;

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
public class RegiaoService implements IRegiaoService {

    private final IRegiaoRepository regiaoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Regiao> findAll() {
        return regiaoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Regiao findById(final Long id) throws EntityNotFoundException {
        return regiaoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public void createRegiao(Regiao regiao) {
        regiaoRepository.save(regiao);
    }

    @Override
    @Transactional
    public void updateRegiao(long id, Regiao regiao) throws EntityNotFoundException {

        Regiao regiaoExiste = this.findById(id);
        regiao.setId(regiaoExiste.getId());

        regiaoRepository.save(regiao);
    }

    @Override
    public void delete(final Long id) throws EntityNotFoundException {
        try {
            regiaoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("N??o foi poss??vel excluir. Viola????o de integridade.", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new InternalServerError("Erro interno. Por favor entrar em contato com o suporte.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
