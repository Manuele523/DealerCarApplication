package it.dealercar.Manager.Interface;

import it.dealercar.DTO.CarOwnerDTO;

public interface ServiceManager {

    void buyCar(Long idModel, Long idOwner);

    void sellCar(CarOwnerDTO carOwner);

    void changePracticeStatus(CarOwnerDTO carOwner, String status);

}
