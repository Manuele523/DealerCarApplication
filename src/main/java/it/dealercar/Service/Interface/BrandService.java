package it.dealercar.Service.Interface;

import it.dealercar.Entity.BrandEntity;

import java.util.List;

public interface BrandService {

    List<BrandEntity> findAll();

    String insert(BrandEntity brand) throws Exception;

    String delete(Long idBrand) throws Exception;

    String update(BrandEntity brand) throws Exception;

}
