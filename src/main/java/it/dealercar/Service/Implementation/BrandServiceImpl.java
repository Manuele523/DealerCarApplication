package it.dealercar.Service.Implementation;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Repository.BrandRepository;
import it.dealercar.Service.Interface.BrandService;
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
    public void insert(BrandEntity brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long idBrand) {
        brandRepository.deleteById(idBrand);
    }

    @Override
    public void update(BrandEntity brand) {
        brandRepository.save(brand);
    }
}
