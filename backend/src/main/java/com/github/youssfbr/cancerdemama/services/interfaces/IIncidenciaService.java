package com.github.youssfbr.cancerdemama.services.interfaces;

import com.github.youssfbr.cancerdemama.entities.Incidencia;
import com.github.youssfbr.cancerdemama.services.exceptions.EntityNotFoundException;

import java.util.List;

public interface IIncidenciaService {

    List<Incidencia> findAll();
    Incidencia findById(final Long id) throws EntityNotFoundException;
    void createIncidencia(final Incidencia incidencia);
    void updateIncidencia(final long id, final Incidencia incidencia) throws EntityNotFoundException;
    void delete(final Long id) throws EntityNotFoundException;

}
