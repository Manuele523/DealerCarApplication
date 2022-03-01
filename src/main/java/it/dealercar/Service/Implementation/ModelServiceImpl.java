package it.dealercar.Service.Implementation;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Repository.BrandRepository;
import it.dealercar.Repository.ModelRepository;
import it.dealercar.Service.Interface.ModelService;
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
public class ModelServiceImpl implements ModelService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelRepository modelRepository;

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
    public void insert(ModelEntity model) {
        modelRepository.save(model);
    }

    @Override
    public void delete(Long idModel) {
        modelRepository.deleteById(idModel);
    }

    @Override
    public void update(ModelEntity model) {
        modelRepository.save(model);
    }

}
