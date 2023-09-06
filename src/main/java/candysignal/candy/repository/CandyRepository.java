package candysignal.candy.repository;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.CandyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandyRepository extends JpaRepository<Candy,Long> {

    Optional<Candy> findAllByUserId(Long userId);


}
