package com.codigo.RobertoBorja.service.impl;
import com.codigo.RobertoBorja.Mapper.EmpresaMapper;
import com.codigo.RobertoBorja.constants.Constants;
import com.codigo.RobertoBorja.dao.EmpresaRepository;
import com.codigo.RobertoBorja.entity.EmpresaEntity;
import com.codigo.RobertoBorja.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {

        return EmpresaMapper.fromEntity(empresaRepository.save(empresaEntity));
    }

    @Override
    public Optional<EmpresaEntity> buscarxId(Long id) {

        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarAll() {

        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setEsAgenteRetencion(empresaEntity.isEsAgenteRetencion());
            empresa.setEstado(Constants.STATUS_ACTIVE);
            empresa.setUsuaCrea(Constants.USU_ADMIN);
            empresa.setDateCreate(getTimestamp());
            return empresaRepository.save(empresa);
        }
        return null;

    }
    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            return empresaRepository.save(empresaRecuperada.get());
        }
        return null;
    }
}
