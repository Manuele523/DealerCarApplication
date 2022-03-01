package it.dealercar.Service.Implementation;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;
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
    public String insert(BrandEntity brand) {
        try {
            brandRepository.save(brand);
            return "Inserted new Brand! ( " + brand + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in BrandServiceImpl.insert");
            return "It was not possible to insert a new Brand! ( " + brand + " )";
        }
    }

    @Override
    public String delete(Long idBrand) {
        BrandEntity entity = null;
        try {
            entity = brandRepository.getById(idBrand);
            brandRepository.deleteById(idBrand);
            return "Deleted new Brand! ( " + entity + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in BrandServiceImpl.delete");
            return "It wasn't possible to delete Brand! ( " + entity + " )";
        }
    }

    @Override
    public String update(BrandEntity brand) {
        BrandEntity entityOld = null;
        try {
            entityOld = brandRepository.getById(brand.getId());
            brandRepository.save(brand);
            return "update new Brand from ( " + entityOld + " ) to ( " + brand + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in BrandServiceImpl.update");
            return "It wasn't possible to update Brand! ( " + entityOld + " )";
        }
    }

}
