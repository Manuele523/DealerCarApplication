package it.dealercar.Service.Implementation;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Repository.BrandRepository;
import it.dealercar.Service.Interface.BrandService;
import it.dealercar.Utility.MessagePreFormatted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public String insert(BrandEntity entity) throws Exception {
        try {
            brandRepository.save(entity);
            return MessagePreFormatted.buildOkMsgBrand(MessagePreFormatted.ActionType.INSERT, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgBrand(MessagePreFormatted.ActionType.INSERT, entity);
        }
    }

    @Override
    public String delete(Long idBrand) throws Exception {
        BrandEntity entity = brandRepository.getById(idBrand);
        try {
            brandRepository.deleteById(idBrand);
            return MessagePreFormatted.buildOkMsgBrand(MessagePreFormatted.ActionType.DELETE, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgBrand(MessagePreFormatted.ActionType.DELETE, entity);
        }
    }

    @Override
    public String update(BrandEntity brand) throws Exception {
        BrandEntity entityOld = brandRepository.getById(brand.getId());
        try {
            brandRepository.save(brand);
            return MessagePreFormatted.buildOkMsgBrand(MessagePreFormatted.ActionType.UPDATE, brand);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgBrand(MessagePreFormatted.ActionType.UPDATE, entityOld);
        }
    }

}
