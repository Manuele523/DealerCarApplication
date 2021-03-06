package it.dealercar.Manager.Implementation;

import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.DTO.OwnerDTO;
import it.dealercar.Manager.Interface.OwnerManager;
import it.dealercar.Mapper.CarOwnerMapper;
import it.dealercar.Mapper.OwnerMapper;
import it.dealercar.Service.Interface.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerManagerImpl implements OwnerManager {

    @Autowired
    private OwnerService ownerService;

    @Override
    public List<OwnerDTO> findAll() {
        return ownerService.findAll().stream().map(OwnerMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarOwnerDTO> findAllCarOfOwner(Long idOwner) {
        return ownerService.findAllCarOfOwner(idOwner).stream().map(CarOwnerMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public String insert(OwnerDTO owner) {
        return ownerService.insert(OwnerMapper.mapToEntity(owner));
    }

    @Override
    public String delete(Long idOwner) {
        return ownerService.delete(idOwner);
    }

    @Override
    public String update(OwnerDTO owner) {
        return ownerService.update(OwnerMapper.mapToEntity(owner));
    }

}
