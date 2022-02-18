package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Manager.Interface.ServiceManager;
import it.dealercar.Service.Interface.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceManagerImpl implements ServiceManager {

    @Autowired
    private ServiceService serviceService;

    @Override
    public void buyCar(Long idModel, Long idOwner) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = new CarOwnerEntity(
                null,
                idModel,
                idOwner,
                today,
                null
        );
        serviceService.buyCar(carOwnerEntity);
    }

    @Override
    public void sellCar(CarOwnerDTO carOwner) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = new CarOwnerEntity(
                carOwner.getId(),
                carOwner.getIdModel(),
                carOwner.getIdOwner(),
                carOwner.getPurchaseDate(),
                today
        );

        serviceService.sellCar(carOwnerEntity);
    }
}
