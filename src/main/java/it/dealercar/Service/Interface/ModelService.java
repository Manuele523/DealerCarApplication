package it.dealercar.Service.Interface;

import it.dealercar.Entity.ModelEntity;

import java.util.List;

public interface ModelService {

    List<ModelEntity> findAll();

    List<ModelEntity> findAllModelByBrand(Long idBrand);

    String insert(ModelEntity model) throws Exception;

    String delete(Long idModel) throws Exception;

    String update(ModelEntity model) throws Exception;

    void deleteByBrand(Long idBrand);

}
