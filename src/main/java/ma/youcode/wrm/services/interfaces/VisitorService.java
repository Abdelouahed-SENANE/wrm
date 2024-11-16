package ma.youcode.wrm.services.interfaces;


import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.visitor.VisitorCreateDTO;
import ma.youcode.wrm.dto.request.visitor.VisitorUpdateDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorResponseDTO;
import ma.youcode.wrm.entities.Visitor;
import org.springframework.data.domain.Page;

public interface VisitorService extends GenericService<Visitor> {

    VisitorResponseDTO create(VisitorCreateDTO createDTO);
    VisitorResponseDTO update(VisitorUpdateDTO updateDTO , Long id);
    void delete(Long id);
    VisitorResponseDTO read(Long id);
    Page<VisitorResponseDTO> readAll(int page , int size);



}
