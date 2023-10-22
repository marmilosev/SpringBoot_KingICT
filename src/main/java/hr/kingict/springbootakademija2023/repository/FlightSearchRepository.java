package hr.kingict.springbootakademija2023.repository;

import hr.kingict.springbootakademija2023.entity.FlightSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchRepository extends JpaRepository<FlightSearchEntity, Long> {

}
