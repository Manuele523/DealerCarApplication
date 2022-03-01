package it.dealercar.Manager.Interface;

import it.dealercar.DTO.BrandDTO;

import java.util.List;

public interface BrandManager {

    List<BrandDTO> findAll();

    void insert(BrandDTO brand);

    void delete(Long idBrand);

    void update(BrandDTO brand);
}
