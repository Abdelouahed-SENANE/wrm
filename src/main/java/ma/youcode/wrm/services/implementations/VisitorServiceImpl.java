package ma.youcode.wrm.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.common.GenericServiceImpl;
import ma.youcode.wrm.dto.request.visitor.VisitorCreateDTO;
import ma.youcode.wrm.dto.request.visitor.VisitorUpdateDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorResponseDTO;
import ma.youcode.wrm.entities.Visitor;
import ma.youcode.wrm.mappers.VisitorMapper;
import ma.youcode.wrm.repositories.VisitorRepository;
import ma.youcode.wrm.services.interfaces.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VisitorServiceImpl extends GenericServiceImpl<Visitor> implements VisitorService {

    public VisitorServiceImpl() {
        super(Visitor.class);
    }

    @Autowired
    private VisitorRepository repository;
    @Autowired
    private VisitorMapper mapper;

    @Override
    public VisitorResponseDTO create(VisitorCreateDTO createDTO) {

        Visitor newVisitor = mapper.fromCreateDTO(createDTO);
        return mapper.toResponseDTO(repository.save(newVisitor));
    }

    @Override
    public void delete(Long id) {

        if (!isExist(id)) {
            throw new EntityNotFoundException("Visit not found.");
        }

        repository.deleteById(id);
    }

    @Override
    public VisitorResponseDTO update(VisitorUpdateDTO updateDTO, Long id) {
        if (!isExist(id)) {
            throw new EntityNotFoundException("Visit not found.");
        }


        Visitor updatedVisitor = mapper.fromUpdateDTO(updateDTO);
        updatedVisitor.setId(id);

        return mapper.toResponseDTO(repository.save(updatedVisitor));
    }


    @Override
    public VisitorResponseDTO read(Long id) {
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visitor not found.")));
    }

    @Override
    public Page<VisitorResponseDTO> readAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Visitor> visitorPage = repository.findAll(pageable);
        return visitorPage.map(mapper::toResponseDTO);
    }





}
