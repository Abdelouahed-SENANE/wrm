package ma.youcode.wrm.services.interfaces;

import ma.youcode.wrm.dto.request.WaitingListRequestDTO;
import ma.youcode.wrm.dto.response.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WaitingListService {

    WaitingListResponseDTO create(WaitingListRequestDTO requestDTO);
    WaitingListResponseDTO update(WaitingListRequestDTO requestDTO , Long id);
    void delete(Long id);
    WaitingListResponseDTO read(Long id);
    Page<WaitingListResponseDTO> readAll(int page , int size);
}
