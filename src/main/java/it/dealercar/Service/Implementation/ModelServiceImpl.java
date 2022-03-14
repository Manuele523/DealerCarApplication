package it.dealercar.Service.Implementation;

import it.dealercar.Entity.ModelEntity;
import it.dealercar.Repository.ModelRepository;
import it.dealercar.Service.Interface.ModelService;
import it.dealercar.Utility.MessagePreFormatted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
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
            System.out.println("Error in ModelServiceImpl.findAllModelByBrand! \nWith idBrand: " + idBrand);
        }
        return null;
    }

    @Override
    public String insert(ModelEntity entity) throws Exception {
        try {
            modelRepository.save(entity);
            return MessagePreFormatted.buildOkMsgModel(MessagePreFormatted.ActionType.INSERT, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgModel(MessagePreFormatted.ActionType.INSERT, entity);
        }
    }

    @Override
    public String delete(Long idModel) throws Exception {
        ModelEntity entity = modelRepository.getById(idModel);;
        try {
            modelRepository.deleteById(idModel);
            return MessagePreFormatted.buildOkMsgModel(MessagePreFormatted.ActionType.DELETE, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgModel(MessagePreFormatted.ActionType.DELETE, entity);
        }
    }

    @Override
    @Transactional
    public void deleteByBrand(Long idBrand) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaDelete<ModelEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(ModelEntity.class);
            Root<ModelEntity> root = criteriaDelete.from(ModelEntity.class);

            criteriaDelete.where(criteriaBuilder.equal(root.get("brand").get("id"), idBrand));

            entityManager.createQuery(criteriaDelete).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in ModelServiceImpl.deleteByBrand! \nWith idBrand: " + idBrand);
        }
    }

    @Override
    public String update(ModelEntity entityNew) throws Exception {
        ModelEntity entityOld = modelRepository.getById(entityNew.getId());
        try {
            modelRepository.save(entityNew);
            return MessagePreFormatted.buildOkMsgModel(MessagePreFormatted.ActionType.UPDATE, entityNew);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgModel(MessagePreFormatted.ActionType.UPDATE, entityOld);
        }
    }

}
