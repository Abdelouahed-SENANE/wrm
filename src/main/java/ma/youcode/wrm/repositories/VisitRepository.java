package ma.youcode.wrm.repositories;

import ma.youcode.wrm.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit , Long> {

    @Query("SELECT " +
            "CASE WHEN COUNT(v) = 0 THEN 0 ELSE " +
            "SUM(CASE WHEN v.status = 'CANCELLED' THEN 1 ELSE 0 END) * 1.0 / COUNT(v) * 100 END " +
            "FROM Visit v " +
            "WHERE v.waitingList.id = :waitingListId")

    Double calculateTurnoverRateOfWaitingList(@Param("waitingListId") Long waitingListId);

    @Query("SELECT calc_average_waiting_time(:waitingListId) ")
    Double calculateAverageWaitingTimeOfWaitingList(@Param("waitingListId") Long waitingListId);

    @Query("SELECT calc_satisfaction_rate(:waitingListId) ")
    Double calculateSatisfactionRateOfWaitingList(@Param("waitingListId") Long waitingListId);
}
