package it.dealercar.Service.Implementation;

import it.dealercar.Entity.CarOwnerEntity;
import it.dealercar.Entity.ModelEntity;
import it.dealercar.Entity.OwnerEntity;
import it.dealercar.Repository.CarOwnerRepository;
import it.dealercar.Repository.OwnerRepository;
import it.dealercar.Service.Interface.OwnerService;
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
    public void insert(OwnerEntity mapToEntity) {
        ownerRepository.save(mapToEntity);
    }

    @Override
    public void delete(Long idOwner) {
        ownerRepository.deleteById(idOwner);
    }

    @Override
    public void update(OwnerEntity mapToEntity) {
        ownerRepository.save(mapToEntity);
    }

}
