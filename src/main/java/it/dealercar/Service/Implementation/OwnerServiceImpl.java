package it.dealercar.Service.Implementation;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Entity.OwnerEntity;
import it.dealercar.Repository.CarOwnerRepository;
import it.dealercar.Repository.OwnerRepository;
import it.dealercar.Service.Interface.OwnerService;
import it.dealercar.Utility.MessagePreFormatted;
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
public class OwnerServiceImpl implements OwnerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Override
    public List<OwnerEntity> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<CarOwnerEntity> findAllCarOfOwner(Long idOwner) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<CarOwnerEntity> criteriaQuery = criteriaBuilder.createQuery(CarOwnerEntity.class);
            Root<CarOwnerEntity> root = criteriaQuery.from(CarOwnerEntity.class);
            criteriaQuery.select(root);

            criteriaQuery.where(criteriaBuilder.equal(root.get("owner").get("id"), idOwner));

            TypedQuery<CarOwnerEntity> query = entityManager.createQuery(criteriaQuery);

            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error in OwnerServiceImpl.findAllCarOfOwner! \nWith idOwner: " + idOwner);
        }

        return null;
    }

    @Override
    public String insert(OwnerEntity entity) {
        try {
            ownerRepository.save(entity);
            return MessagePreFormatted.buildOkMsgOwner(MessagePreFormatted.ActionType.INSERT, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgOwner(MessagePreFormatted.ActionType.INSERT, entity);
        }
    }

    @Override
    public String delete(Long idOwner) {
        OwnerEntity oldOwner = ownerRepository.getById(idOwner);
        try {
            ownerRepository.deleteById(idOwner);
            return MessagePreFormatted.buildOkMsgOwner(MessagePreFormatted.ActionType.DELETE, oldOwner);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgOwner(MessagePreFormatted.ActionType.DELETE, oldOwner);
        }
    }

    @Override
    public String update(OwnerEntity entity) {
        OwnerEntity oldOwner = ownerRepository.getById(entity.getId());
        try {
            ownerRepository.save(entity);
            return MessagePreFormatted.buildOkMsgOwner(MessagePreFormatted.ActionType.UPDATE, entity);
        } catch (Exception e) {
            return MessagePreFormatted.buildKoMsgOwner(MessagePreFormatted.ActionType.UPDATE, oldOwner);
        }
    }

}
