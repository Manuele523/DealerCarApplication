package it.dealercar.Service.Implementation;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Entity.OwnerEntity;
import it.dealercar.Repository.CarOwnerRepository;
import it.dealercar.Repository.OwnerRepository;
import it.dealercar.Service.Interface.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Override
    public List<OwnerEntity> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<CarOwnerEntity> findAllCarOfOwner() {
        return carOwnerRepository.findAll();
    }

}
