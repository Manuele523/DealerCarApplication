package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.ModelManager;
import it.dealercar.Mapper.ModelMapper;
import it.dealercar.Service.Interface.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManagerImpl implements ModelManager {

    @Autowired
    private ModelService modelService;

    @Override
    public List<ModelDTO> findAll() {
        return modelService.findAll().stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> findAllModelByBrand(Long idBrand) {
        return modelService.findAllModelByBrand(idBrand).stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void insert(ModelDTO model) {
        modelService.insert(ModelMapper.mapToEntity(model));
    }

    @Override
    public void delete(Long idModel) {
        modelService.delete(idModel);
    }

    @Override
    public void update(ModelDTO model) {
        modelService.update(ModelMapper.mapToEntity(model));
    }

}
