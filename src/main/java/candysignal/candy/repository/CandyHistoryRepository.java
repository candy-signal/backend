package candysignal.candy.repository;

import candysignal.candy.entity.CandyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandyHistoryRepository extends JpaRepository<CandyHistory,Long> {
}
