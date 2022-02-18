package it.dealercar.Service.Interface;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;

import java.util.List;

public interface CarService {

    // MODEL
    List<ModelEntity> findAll();

    List<ModelEntity> findAllModelByBrand(Long idBrand);

    void insertModel(ModelEntity model);

    void deleteModel(Long idModel);

    void updateModel(ModelEntity model);

    // BRAND
    List<BrandEntity> findAllBrand();

    void insertBrand(BrandEntity brand);

    void deleteBrand(Long idBrand);

    void updateBrand(BrandEntity brand);
}
