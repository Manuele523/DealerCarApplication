package it.dealercar.Mapper;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Utility.Mapper;


public class CarOwnerMapper extends Mapper {

    public static CarOwnerDTO mapToDTO(CarOwnerEntity entity) {
       return mapper.convertValue(entity, CarOwnerDTO.class);
    }

    public static CarOwnerEntity mapToEntity(CarOwnerDTO dto) {
        return mapper.convertValue(dto, CarOwnerEntity.class);
    }

}

