package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Manager.Interface.BrandManager;
import it.dealercar.Mapper.BrandMapper;
import it.dealercar.Service.Interface.BrandService;
import it.dealercar.Service.Interface.ModelService;
import it.dealercar.Service.Interface.ServiceService;
import it.dealercar.Utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManagerImpl implements BrandManager {

    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private ServiceService serviceService;

    @Override
    public List<BrandDTO> findAll() {
        return brandService.findAll().stream().map(BrandMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public String insert(BrandDTO brand) throws Exception {
        return brandService.insert(BrandMapper.mapToEntity(brand));
    }

    @Override
    public String delete(Long idBrand) throws Exception {
        try {
            modelService.deleteByBrand(idBrand);
            return brandService.delete(idBrand);
        } catch (Exception e) {
            System.out.println("Error in BrandManagerImpl.delete!");
        }
        return null;
    }

    @Override
    public String update(BrandDTO brand) throws Exception {
        return brandService.update(BrandMapper.mapToEntity(brand));
    }

    @Override
    public Object checkIfHaveAssociationWithModel(Long idBrand) {
        if (serviceService.checkIfHaveAssociation(idBrand, null)) {
            return Constant.CodeStatWarning.BRAND_ASSOCIATED_FOUND.getCode() + " - " + Constant.CodeStatWarning.BRAND_ASSOCIATED_FOUND.getDescription();
        } else {
            return false;
        }
    }

}
