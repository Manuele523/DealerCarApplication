package it.dealercar.Service.Interface;

import it.dealercar.Entity.ModelEntity;

import java.util.List;

public interface ModelService {

    List<ModelEntity> findAll();

    List<ModelEntity> findAllModelByBrand(Long idBrand);

    String insert(ModelEntity model);

    String delete(Long idModel);

    String update(ModelEntity model);

}
