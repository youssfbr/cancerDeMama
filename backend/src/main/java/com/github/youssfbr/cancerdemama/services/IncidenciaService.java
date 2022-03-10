package com.github.youssfbr.cancerdemama.services;

import com.github.youssfbr.cancerdemama.entities.Incidencia;
import com.github.youssfbr.cancerdemama.repositories.IIncidenciaRepository;
import com.github.youssfbr.cancerdemama.services.exceptions.DatabaseException;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;
import com.github.youssfbr.cancerdemama.services.exceptions.InternalServerError;
import com.github.youssfbr.cancerdemama.services.interfaces.IIncidenciaService;

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
public class IncidenciaService implements IIncidenciaService {

    private final IIncidenciaRepository incidenciaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Incidencia> findAll() {
        return incidenciaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Incidencia findById(final Long id) throws EntityNotFoundException {
        return incidenciaRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public void createIncidencia(Incidencia incidencia) {
        incidenciaRepository.save(incidencia);
    }

    @Override
    @Transactional
    public void updateIncidencia(long id, Incidencia incidencia) throws EntityNotFoundException {

        Incidencia incidenciaExiste = this.findById(id);
        incidencia.setId(incidenciaExiste.getId());

        incidenciaRepository.save(incidencia);
    }

    @Override
    public void delete(final Long id) throws EntityNotFoundException {
        try {
            incidenciaRepository.deleteById(id);
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
