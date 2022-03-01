package it.dealercar.Service.Implementation;

import it.dealercar.Entity.ModelEntity;
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
    public String insert(ModelEntity model) {
        try {
            modelRepository.save(model);
            return "Inserted new Model! ( " + model + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in ModelServiceImpl.insert");
            return "It was not possible to insert a new Model! ( " + model + " )";
        }
    }

    @Override
    public String delete(Long idModel) {
        ModelEntity entity = null;
        try {
            entity = modelRepository.getById(idModel);
            modelRepository.deleteById(idModel);
            return "Deleted new Model! ( " + entity + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in ModelServiceImpl.delete");
            return "It wasn't possible to delete Model! ( " + entity + " )";
        }
    }

    @Override
    public String update(ModelEntity model) {
        ModelEntity entityOld = null;
        try {
            entityOld = modelRepository.getById(model.getId());
            modelRepository.save(model);
            return "update new Model from ( " + entityOld + " ) to ( " + model + " )";
        } catch (Exception e) {
            System.out.println("Error! Broken in ModelServiceImpl.update");
            return "It wasn't possible to update Model! ( " + entityOld + " )";
        }
    }

}
