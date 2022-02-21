package it.dealercar.Service.Interface;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Entity.OwnerEntity;

import java.util.Arrays;
import java.util.List;

public interface OwnerService {

    List<OwnerEntity> findAll();

    List<CarOwnerEntity> findAllCarOfOwner(Long idOwner);

    void insert(OwnerEntity mapToEntity);

    void delete(Long idOwner);

    void update(OwnerEntity mapToEntity);

}
