package ma.youcode.wrm.services.interfaces;

import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import org.springframework.data.domain.Page;

public interface VisitService {
    VisitResponseDTO create(VisitUpdateDTO requestDTO);
    VisitResponseDTO update(VisitUpdateDTO requestDTO , Long id);
    void delete(Long id);
    VisitResponseDTO read(Long id);
    Page<VisitResponseDTO> readAll(int page , int size);
}
