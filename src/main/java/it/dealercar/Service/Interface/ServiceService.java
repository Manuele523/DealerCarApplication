package it.dealercar.Service.Interface;

import it.dealercar.Entity.CarOwnerEntity;

import java.util.Arrays;
import java.util.List;

public interface ServiceService {

    void buyCar(CarOwnerEntity carOwnerEntity);

    void sellCar(CarOwnerEntity carOwnerEntity);

    void changePracticeStatus(CarOwnerEntity carOwnerEntity);

    Boolean checkIfHaveAssociation(Long idBrand, Long idModel);

    List<CarOwnerEntity> findAllCarOwner();

}
