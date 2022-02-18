package it.dealercar.Manager.Interface;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.DTO.OwnerDTO;

import java.util.List;

public interface OwnerManager {

    List<OwnerDTO> findAll();

    List<CarOwnerDTO> findAllCarOfOwner(Long idOwner);

}
