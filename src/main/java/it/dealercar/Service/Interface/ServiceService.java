package it.dealercar.Service.Interface;

import it.dealercar.Entity.CarOwnerEntity;

public interface ServiceService {

    void buyCar(CarOwnerEntity carOwnerEntity);

    void sellCar(CarOwnerEntity carOwnerEntity);

    void changePracticeStatus(CarOwnerEntity carOwnerEntity);

}
