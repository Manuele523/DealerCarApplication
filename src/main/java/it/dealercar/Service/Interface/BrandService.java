package it.dealercar.Service.Interface;

import it.dealercar.Entity.BrandEntity;

import java.util.List;

public interface BrandService {

    List<BrandEntity> findAll();

    void insert(BrandEntity brand);

    void delete(Long idBrand);

    void update(BrandEntity brand);

}
