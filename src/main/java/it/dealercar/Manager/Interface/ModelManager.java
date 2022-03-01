package it.dealercar.Manager.Interface;

import it.dealercar.DTO.ModelDTO;

import java.util.List;

public interface ModelManager {

    // MODEL
    List<ModelDTO> findAll();

    List<ModelDTO> findAllModelByBrand(Long idBrand);

    void insert(ModelDTO model);

    void delete(Long idModel);

    void update(ModelDTO model);

}
