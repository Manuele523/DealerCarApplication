package it.dealercar.Service.Interface;

import it.dealercar.Entity.BrandEntity;

import java.util.List;

public interface BrandService {

    List<BrandEntity> findAll();

    String insert(BrandEntity brand);

    String delete(Long idBrand);

    String update(BrandEntity brand);

}
