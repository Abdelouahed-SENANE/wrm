package ma.youcode.wrm.services.interfaces;

import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.waitingList.WaitingListCreateDTO;
import ma.youcode.wrm.dto.request.waitingList.WaitingListUpdateDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import org.springframework.data.domain.Page;

public interface WaitingListService extends GenericService<WaitingList> {

    WaitingListResponseDTO create(WaitingListCreateDTO requestDTO);
    WaitingListResponseDTO update(WaitingListUpdateDTO requestDTO , Long id);
    void delete(Long id);
    WaitingListResponseDTO read(Long id);
    Page<WaitingListResponseDTO> readAll(int page , int size);
    Page<WaitingListResponseDTO> readAllWithSortedVisits(int page , int size );
    WaitingListResponseDTO readWithSortedVisits(Long id );

}
