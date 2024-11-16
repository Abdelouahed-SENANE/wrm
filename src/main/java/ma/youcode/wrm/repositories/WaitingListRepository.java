package ma.youcode.wrm.repositories;

import ma.youcode.wrm.entities.WaitingList;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList , Long> {


    @Query("select wl from WaitingList wl left join fetch wl.visits v " +
            "ORDER BY case when wl.algorithm = 'FIFO' then v.arrivalTime " +
            " when wl.algorithm = 'PHF' then v.priority " +
            "when wl.algorithm = 'SJF' then v.estimatedProcessingTime end")
    Page<WaitingList> findAllWithSortedVisits(Pageable pageable);

    @Query("select wl from WaitingList wl left join fetch wl.visits v " +
            " where  wl.id = :id " +
            "ORDER BY case when wl.algorithm = 'FIFO' then v.arrivalTime " +
            " when wl.algorithm = 'PHF' then v.priority " +
            "when wl.algorithm = 'SJF' then v.estimatedProcessingTime end")
    WaitingList findWithSortedVisits(@Param("id") Long id);
}
