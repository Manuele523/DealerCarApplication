package it.dealercar.Mapper;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Entity.BrandEntity;
import it.dealercar.Utility.Mapper;


public class BrandMapper extends Mapper {

    public static BrandDTO mapToDTO(BrandEntity entity) {
       return mapper.convertValue(entity, BrandDTO.class);
    }

    public static BrandEntity mapToEntity(BrandDTO dto) {
        return mapper.convertValue(dto, BrandEntity.class);
    }

}

