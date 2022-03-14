package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.ModelManager;
import it.dealercar.Mapper.ModelMapper;
import it.dealercar.Service.Interface.ModelService;
import it.dealercar.Service.Interface.ServiceService;
import it.dealercar.Utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManagerImpl implements ModelManager {

    @Autowired
    private ModelService modelService;
    @Autowired
    private ServiceService serviceService;

    @Override
    public List<ModelDTO> findAll() {
        return modelService.findAll().stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> findAllModelByBrand(Long idBrand) {
        return modelService.findAllModelByBrand(idBrand).stream().map(ModelMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public String insert(ModelDTO model) throws Exception {
        return modelService.insert(ModelMapper.mapToEntity(model));
    }

    @Override
    public Boolean delete(Long idModel) throws Exception {
        try {
            modelService.delete(idModel);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String update(ModelDTO model) throws Exception {
        return modelService.update(ModelMapper.mapToEntity(model));
    }

    @Override
    public Object checkIfHaveAssociationWithOwner(Long idModel) {
        if (serviceService.checkIfHaveAssociation(null, idModel)) {
            return Constant.CodeStatWarning.MODEL_ASSOCIATED_FOUND.getCode() + " - " + Constant.CodeStatWarning.MODEL_ASSOCIATED_FOUND.getDescription();
        } else {
            return false;
        }
    }


}
