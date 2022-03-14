package it.dealercar.Service.Implementation;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Repository.CarOwnerRepository;
import it.dealercar.Service.Interface.ServiceService;
import it.dealercar.Utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Override
    public List<CarOwnerEntity> findAllCarOwner() {
        return carOwnerRepository.findAll();
    }

    @Override
    @Transactional
    public void buyCar(CarOwnerEntity carOwnerEntity) {
        carOwnerRepository.save(carOwnerEntity);
    }

    @Override
    @Transactional
    public void sellCar(CarOwnerEntity carOwnerEntity) {
        carOwnerRepository.save(carOwnerEntity);
    }

    @Override
    @Transactional
    public void changePracticeStatus(CarOwnerEntity carOwnerEntity) {
        carOwnerRepository.save(carOwnerEntity);
    }

    @Override
    public Boolean checkIfHaveAssociation(Long idBrand, Long idModel) {
        String strType = Constant.EMPTY_STRING;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<CarOwnerEntity> criteriaQuery = criteriaBuilder.createQuery(CarOwnerEntity.class);
            Root<CarOwnerEntity> root = criteriaQuery.from(CarOwnerEntity.class);

            if (idBrand != null) {
                strType = "idBrand: ";
                criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("model").get("brand").get("id"), idBrand));
            } else if (idModel != null) {
                strType = "idModel: ";
                criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("model").get("id"), idModel));
            }

            TypedQuery<CarOwnerEntity> query = entityManager.createQuery(criteriaQuery);

            return !query.getResultList().isEmpty();
        } catch (Exception e) {
            System.out.println("Error in ServiceServiceImpl.checkIfHaveAssociation with " + strType + idModel);
        }
        return null;
    }

}
