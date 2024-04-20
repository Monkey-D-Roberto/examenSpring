package com.codigo.RobertoBorja.service;

import com.codigo.RobertoBorja.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaEntity crear(EmpresaEntity empresaEntity);
    Optional<EmpresaEntity> buscarxId(Long id);
    List<EmpresaEntity> buscarAll();
    EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity);
    EmpresaEntity borrar(Long id);
}
