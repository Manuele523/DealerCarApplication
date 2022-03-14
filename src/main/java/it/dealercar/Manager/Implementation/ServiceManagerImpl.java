package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Entity.OwnerEntity;
import it.dealercar.Enum.StatusPractice;
import it.dealercar.Manager.Interface.ServiceManager;
import it.dealercar.Mapper.CarOwnerMapper;
import it.dealercar.Service.Interface.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceManagerImpl implements ServiceManager {

    @Autowired
    private ServiceService serviceService;

    @Override
    public List<CarOwnerDTO> findAllCarOwner() {
        return serviceService.findAllCarOwner().stream().map(CarOwnerMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void buyCar(Long idModel, Long idOwner) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = new CarOwnerEntity(null, new OwnerEntity(idOwner), new ModelEntity(idModel), today, null, today, StatusPractice.START);

        serviceService.buyCar(carOwnerEntity);
    }

    @Override
    public void sellCar(CarOwnerDTO carOwner) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = CarOwnerMapper.mapToEntity(carOwner);
        carOwnerEntity.setSellDate(today);
        carOwnerEntity.setStatusPractice(StatusPractice.ON_DISPLAY);

        serviceService.sellCar(carOwnerEntity);
    }

    @Override
    public void changePracticeStatus(CarOwnerDTO carOwner, String status) {
        Date today = new Date();
        CarOwnerEntity carOwnerEntity = CarOwnerMapper.mapToEntity(carOwner);
        carOwnerEntity.setDateLastEdit(today);
        carOwnerEntity.setStatusPractice(StatusPractice.valueOf(status));

        serviceService.changePracticeStatus(carOwnerEntity);
    }

}
