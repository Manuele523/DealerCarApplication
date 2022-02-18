package it.dealercar.Service.Implementation;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.DTO.ModelDTO;
import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Repository.BrandRepository;
import it.dealercar.Repository.ModelRepository;
import it.dealercar.Service.Interface.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;

    // MODEL
    @Override
    public List<ModelEntity> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public List<ModelEntity> findAllModelByBrand(Long idBrand) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<ModelEntity> criteriaQuery = criteriaBuilder.createQuery(ModelEntity.class);
            Root<ModelEntity> root = criteriaQuery.from(ModelEntity.class);
            criteriaQuery.select(root);

            criteriaQuery.where(criteriaBuilder.equal(root.get("brand").get("id"), idBrand));

            TypedQuery<ModelEntity> query = entityManager.createQuery(criteriaQuery);

            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error in CarServiceImpl.findAllModelByBrand! \nWith idBrand: " + idBrand);
        }

        return null;
    }

    @Override
    public void insertModel(ModelEntity model) {
        modelRepository.save(model);
    }

    @Override
    public void deleteModel(Long idModel) {
        modelRepository.deleteById(idModel);
    }

    @Override
    public void updateModel(ModelEntity model) {
        modelRepository.save(model);
    }

    // BRAND
    @Override
    public List<BrandEntity> findAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public void insertBrand(BrandEntity brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long idBrand) {
        brandRepository.deleteById(idBrand);
    }

    @Override
    public void updateBrand(BrandEntity brand) {
        brandRepository.save(brand);
    }
}
