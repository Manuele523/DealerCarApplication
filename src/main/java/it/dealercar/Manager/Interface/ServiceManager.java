package it.dealercar.Manager.Interface;

import it.dealercar.DTO.CarOwnerDTO;

import java.util.List;

public interface ServiceManager {

    void buyCar(Long idModel, Long idOwner);

    void sellCar(CarOwnerDTO carOwner);

    void changePracticeStatus(CarOwnerDTO carOwner, String status);

    List<CarOwnerDTO> findAllCarOwner();

}
