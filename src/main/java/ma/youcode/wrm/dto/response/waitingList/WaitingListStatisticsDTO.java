package ma.youcode.wrm.dto.response.waitingList;

import java.time.LocalDateTime;

public record WaitingListStatisticsDTO(
        Long id,
        LocalDateTime date,
        Double turnoverRate,
        Double averageWaitingTime,
        Double satisfactionRate
) {
}
