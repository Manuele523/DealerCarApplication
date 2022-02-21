package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Enum.StatusPractice;
import it.dealercar.Manager.Interface.ServiceManager;
import it.dealercar.Mapper.CarOwnerMapper;
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
                null,
                today,
                StatusPractice.START.name()
        );

        serviceService.buyCar(carOwnerEntity);
    }

    @Override
    public void sellCar(CarOwnerDTO carOwner) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = CarOwnerMapper.mapToEntity(carOwner);
        carOwnerEntity.setSellDate(today);
        carOwnerEntity.setStatusPractice(StatusPractice.ON_DISPLAY.name());

        serviceService.sellCar(carOwnerEntity);
    }

    @Override
    public void changePracticeStatus(CarOwnerDTO carOwner, String status) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = CarOwnerMapper.mapToEntity(carOwner);
        carOwnerEntity.setDateLastEdit(today);
        carOwnerEntity.setStatusPractice(status);

        serviceService.changePracticeStatus(carOwnerEntity);
    }
}
