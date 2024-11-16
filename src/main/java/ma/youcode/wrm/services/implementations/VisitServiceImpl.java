package ma.youcode.wrm.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.common.GenericServiceImpl;
import ma.youcode.wrm.dto.request.visit.VisitCreateDTO;
import ma.youcode.wrm.dto.request.visit.VisitEditDTO;
import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorResponseDTO;
import ma.youcode.wrm.entities.Visit;
import ma.youcode.wrm.entities.Visitor;
import ma.youcode.wrm.entities.WaitingList;
import ma.youcode.wrm.mappers.VisitMapper;
import ma.youcode.wrm.repositories.VisitRepository;
import ma.youcode.wrm.services.interfaces.VisitService;
import ma.youcode.wrm.services.interfaces.VisitorService;
import ma.youcode.wrm.services.interfaces.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class VisitServiceImpl extends GenericServiceImpl<Visit> implements VisitService {

    @Autowired
    private VisitRepository repository;
    @Autowired
    private VisitMapper mapper;
    @Autowired
    private WaitingListService waitingListService;
    @Autowired
    private VisitorService visitorService;

    public VisitServiceImpl() {
        super(Visit.class);
    }


    @Override
    public VisitResponseDTO create(VisitCreateDTO createDTO) {

        WaitingList waitingList = findWaitingList(createDTO.waitingListId());
        Visitor visitor = findVisitor(createDTO.visitorId());

        Visit visit = mapper.fromCreateDTO(createDTO);
        validateVisit(visit, waitingList);

        visit.setVisitor(visitor);
        visit.setWaitingList(waitingList);

        return saveVisit(visit);
    }

    @Override
    public void delete(Long id) {

        if (!isExist(id)) {
            throw new EntityNotFoundException("Visit not found.");
        }

        repository.deleteById(id);
    }

    @Override
    public VisitResponseDTO update(VisitUpdateDTO updateDTO, Long id) {

        if (!isExist(id)) {
           throw new EntityNotFoundException("Visit not found.");
        }

        WaitingList waitingList = findWaitingList(updateDTO.waitingListId());

        Visit visit = mapper.fromUpdateDTO(updateDTO);
        validateVisit(visit, waitingList);
        visit.setId(id);

        return saveVisit(visit);
    }

    @Override
    public VisitResponseDTO edit(VisitEditDTO editDTO, Long id) {

        Visit visit = repository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Visit not found."));

        if (editDTO.endTime() != null){
            visit.setEndTime(editDTO.endTime());
        }
        if (editDTO.startTime() != null){
            visit.setStartTime(editDTO.startTime());
        }

        return mapper.toResponseDTO(repository.save(visit));
    }

    @Override
    public VisitResponseDTO read(Long id) {
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found.")));
    }

    @Override
    public Page<VisitResponseDTO> readAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Visit> visitPage = repository.findAll(pageable);
        return visitPage.map(mapper::toResponseDTO);
    }

    private WaitingList findWaitingList(Long id) {
        WaitingList waitingList = waitingListService.findById(id);

        if (waitingList == null) {
            throw new EntityNotFoundException("Waiting list not found.");
        }

        return waitingList;
    }

    private Visitor findVisitor(Long id) {
        Visitor visitor = visitorService.findById(id);
        if (visitor == null) {
            throw new EntityNotFoundException("Visitor not found.");
        }
        return visitor;
    }

    private void validateVisit(Visit visit, WaitingList waitingList) {
        if (!"FIFO".equals(waitingList.getAlgorithm())) {
            switch (waitingList.getAlgorithm()) {
                case "PHF":
                    if (visit.getPriority() == null) {
                        throw new IllegalArgumentException("To apply the priority first algorithm, it's mandatory to have the priority value!");
                    }
                    break;
                case "SJF":
                    if (visit.getEstimatedProcessingTime() == null) {
                        throw new IllegalArgumentException("To apply algorithm SJF, it's mandatory to have the estimated processing time value!");
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Algorithm not found.");
            }
        }
    }

    private VisitResponseDTO saveVisit(Visit visit) {
        return mapper.toResponseDTO(repository.save(visit));
    }
}
