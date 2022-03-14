package it.dealercar.Manager.Interface;

import it.dealercar.DTO.ModelDTO;

import java.util.List;

public interface ModelManager {
    
    List<ModelDTO> findAll();

    List<ModelDTO> findAllModelByBrand(Long idBrand);

    String insert(ModelDTO model) throws Exception;

    Boolean delete(Long idModel) throws Exception;

    String update(ModelDTO model) throws Exception;

    Object checkIfHaveAssociationWithOwner(Long idModel);

}
