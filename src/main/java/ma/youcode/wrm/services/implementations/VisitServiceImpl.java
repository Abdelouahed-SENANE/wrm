package ma.youcode.wrm.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import ma.youcode.wrm.entities.Visit;
import ma.youcode.wrm.mappers.VisitMapper;
import ma.youcode.wrm.repositories.VisitRepository;
import ma.youcode.wrm.services.interfaces.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl extends GenericService<Visit> implements VisitService {

    @Autowired
    private VisitRepository repository;
    @Autowired
    private VisitMapper mapper;


    public VisitServiceImpl(){
        super(Visit.class);
    }


    @Override
    public VisitResponseDTO create(VisitUpdateDTO requestDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public VisitResponseDTO update(VisitUpdateDTO requestDTO, Long id) {
        return null;
    }


    @Override
    public VisitResponseDTO read(Long id) {
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found.")));
    }

    @Override
    public Page<VisitResponseDTO> readAll(int page, int size) {
        return null;
    }

}
