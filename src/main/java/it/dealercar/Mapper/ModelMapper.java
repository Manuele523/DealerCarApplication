package it.dealercar.Mapper;

import it.dealercar.DTO.ModelDTO;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Utility.Mapper;


public class ModelMapper extends Mapper {

    public static ModelDTO mapToDTO(ModelEntity entity) {
       return mapper.convertValue(entity, ModelDTO.class);
    }

    public static ModelEntity mapToEntity(ModelDTO dto) {
        return mapper.convertValue(dto, ModelEntity.class);
    }

}

