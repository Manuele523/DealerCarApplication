package it.dealercar.Manager.Interface;

import it.dealercar.DTO.ModelDTO;

import java.util.List;

public interface ModelManager {
    
    List<ModelDTO> findAll();

    List<ModelDTO> findAllModelByBrand(Long idBrand);

    String insert(ModelDTO model);

    String delete(Long idModel);

    String update(ModelDTO model);

}
