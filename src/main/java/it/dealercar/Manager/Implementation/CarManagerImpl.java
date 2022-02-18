package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.CarManager;
import it.dealercar.Mapper.BrandMapper;
import it.dealercar.Mapper.ModelMapper;
import it.dealercar.Service.Interface.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManagerImpl implements CarManager {

    @Autowired
    private CarService carService;

    // MODEL
    @Override
    public List<ModelDTO> findAll() {
        return carService.findAll().stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> findAllModelByBrand(Long idBrand) {
        return carService.findAllModelByBrand(idBrand).stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void insertModel(ModelDTO model) {
        carService.insertModel(ModelMapper.mapToEntity(model));
    }

    @Override
    public void deleteModel(Long idModel) {
        carService.deleteModel(idModel);
    }

    @Override
    public void updateModel(ModelDTO model) {
        carService.updateModel(ModelMapper.mapToEntity(model));
    }


    // BRAND
    @Override
    public List<BrandDTO> findAllBrand() {
        return carService.findAllBrand().stream().map(BrandMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void insertBrand(BrandDTO brand) {
        carService.insertBrand(BrandMapper.mapToEntity(brand));
    }

    @Override
    public void deleteBrand(Long idBrand) {
        carService.deleteBrand(idBrand);
    }

    @Override
    public void updateBrand(BrandDTO brand) {
        carService.updateBrand(BrandMapper.mapToEntity(brand));
    }

}
