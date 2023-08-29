package candysignal.candy.repository;

import candysignal.candy.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandyRepository extends JpaRepository<Candy,Long> {



}
