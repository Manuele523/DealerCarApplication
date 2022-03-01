package it.dealercar.Service.Interface;

import it.dealercar.Entity.ModelEntity;

import java.util.List;

public interface ModelService {

    List<ModelEntity> findAll();

    List<ModelEntity> findAllModelByBrand(Long idBrand);

    void insert(ModelEntity model);

    void delete(Long idModel);

    void update(ModelEntity model);

}
