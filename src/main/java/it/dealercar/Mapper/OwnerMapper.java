package it.dealercar.Mapper;

import it.dealercar.DTO.OwnerDTO;
import it.dealercar.Entity.OwnerEntity;
import it.dealercar.Utility.Mapper;


public class OwnerMapper extends Mapper {

    public static OwnerDTO mapToDTO(OwnerEntity entity) {
       return mapper.convertValue(entity, OwnerDTO.class);
    }

    public static OwnerEntity mapToEntity(OwnerDTO dto) {
        return mapper.convertValue(dto, OwnerEntity.class);
    }

}

