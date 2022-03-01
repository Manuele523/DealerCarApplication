package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Manager.Interface.BrandManager;
import it.dealercar.Mapper.BrandMapper;
import it.dealercar.Service.Interface.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManagerImpl implements BrandManager {

    @Autowired
    private BrandService brandService;

    @Override
    public List<BrandDTO> findAll() {
        return brandService.findAll().stream().map(BrandMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public String insert(BrandDTO brand) {
        return brandService.insert(BrandMapper.mapToEntity(brand));
    }

    @Override
    public String delete(Long idBrand) {
        return brandService.delete(idBrand);
    }

    @Override
    public String update(BrandDTO brand) {
        return brandService.update(BrandMapper.mapToEntity(brand));
    }

}
