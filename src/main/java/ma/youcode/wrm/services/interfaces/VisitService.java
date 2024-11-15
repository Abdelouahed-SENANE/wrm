package ma.youcode.wrm.services.interfaces;

import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.visit.VisitCreateDTO;
import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import ma.youcode.wrm.entities.Visit;
import org.springframework.data.domain.Page;

public interface VisitService extends GenericService<Visit> {
    VisitResponseDTO create(VisitCreateDTO createDTO);
    VisitResponseDTO update(VisitUpdateDTO updateDTO , Long id);
    void delete(Long id);
    VisitResponseDTO read(Long id);
    Page<VisitResponseDTO> readAll(int page , int size);
}
