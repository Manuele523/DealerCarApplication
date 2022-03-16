package it.dealercar.Manager.Interface;

import it.dealercar.DTO.BrandDTO;

import java.util.List;

public interface BrandManager {

    List<BrandDTO> findAll();

    String insert(BrandDTO brand) throws Exception;

    String delete(Long idBrand) throws Exception;

    String update(BrandDTO brand) throws Exception;

    Object checkIfHaveAssociationWithModel(Long idBrand);

}
