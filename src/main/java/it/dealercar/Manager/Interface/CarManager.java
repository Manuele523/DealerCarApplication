package it.dealercar.Manager.Interface;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.DTO.ModelDTO;

import java.util.List;

public interface CarManager {

    // MODEL
    List<ModelDTO> findAll();

    List<ModelDTO> findAllModelByBrand(Long idBrand);

    void insertModel(ModelDTO model);

    void deleteModel(Long idModel);

    void updateModel(ModelDTO model);

    // BRAND
    List<BrandDTO> findAllBrand();

    void insertBrand(BrandDTO brand);

    void deleteBrand(Long idBrand);

    void updateBrand(BrandDTO brand);
}
