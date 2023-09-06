package candysignal.candy.repository;

import candysignal.candy.entity.CandyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandyHistoryRepository extends JpaRepository<CandyHistory,Long> {

    List<CandyHistory> findAllByUserId(Long userId);

}
