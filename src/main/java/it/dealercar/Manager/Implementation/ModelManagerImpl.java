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
    public String insert(ModelDTO model) {
        return modelService.insert(ModelMapper.mapToEntity(model));
    }

    @Override
    public String delete(Long idModel) {
        return modelService.delete(idModel);
    }

    @Override
    public String update(ModelDTO model) {
        return modelService.update(ModelMapper.mapToEntity(model));
    }

}
