package it.dealercar.Service.Implementation;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Repository.CarOwnerRepository;
import it.dealercar.Service.Interface.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Override
    public void buyCar(CarOwnerEntity carOwnerEntity) {
        carOwnerRepository.save(carOwnerEntity);
    }

    @Override
    public void sellCar(CarOwnerEntity carOwnerEntity) {
        carOwnerRepository.save(carOwnerEntity);
    }

}
