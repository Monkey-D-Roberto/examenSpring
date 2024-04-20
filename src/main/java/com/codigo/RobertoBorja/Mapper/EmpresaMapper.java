package com.codigo.RobertoBorja.Mapper;

import com.codigo.RobertoBorja.entity.EmpresaEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper {
    public static EmpresaEntity fromEntity(EmpresaEntity entity) {
        EmpresaEntity dto = new EmpresaEntity();
        dto.setId(entity.getId());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setNumeroDocumento(entity.getNumeroDocumento());
        dto.setCondicion(entity.getCondicion());
        dto.setDireccion(entity.getDireccion());
        dto.setDistrito(entity.getDistrito());
        dto.setProvincia(entity.getProvincia());
        dto.setDepartamento(entity.getDepartamento());
        dto.setEsAgenteRetencion(entity.isEsAgenteRetencion());
        dto.setEstado(entity.getEstado());
        dto.setUsuaCrea(entity.getUsuaCrea());
        dto.setDateCreate(entity.getDateCreate());
        dto.setUsuaModif(entity.getUsuaModif());
        dto.setDateModif(entity.getDateModif());
        dto.setUsuaDelet(entity.getUsuaDelet());
        dto.setDateDelet(entity.getDateDelet());
        return dto;
    }
}
