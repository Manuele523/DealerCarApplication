package it.dealercar.Repository;

import it.dealercar.Entity.CarOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwnerEntity, Long> {
}
