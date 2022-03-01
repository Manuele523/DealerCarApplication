package it.dealercar.Manager.Interface;

import it.dealercar.DTO.BrandDTO;

import java.util.List;

public interface BrandManager {

    List<BrandDTO> findAll();

    String insert(BrandDTO brand);

    String delete(Long idBrand);

    String update(BrandDTO brand);
}
