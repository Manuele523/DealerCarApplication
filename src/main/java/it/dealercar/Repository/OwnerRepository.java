package it.dealercar.Repository;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}
