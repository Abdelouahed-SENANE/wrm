package ma.youcode.wrm.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.WaitingListRequestDTO;
import ma.youcode.wrm.dto.response.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import ma.youcode.wrm.mapper.WaitingListMapper;
import ma.youcode.wrm.repositories.WaitingListRepository;
import ma.youcode.wrm.services.interfaces.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitingListServiceImpl extends GenericService<WaitingList> implements WaitingListService {

    @Autowired
    private WaitingListMapper mapper;
    @Autowired
    private WaitingListRepository repository;

    public WaitingListServiceImpl() {
        super(WaitingList.class);
    }


    @Override
    public WaitingListResponseDTO create(WaitingListRequestDTO requestDTO) {

        WaitingList waitingList = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(repository.save(waitingList));

    }

    @Override
    public WaitingListResponseDTO update(WaitingListRequestDTO requestDTO, Long id) {

        if (!isExist(id)) {
            throw new EntityNotFoundException("Waiting list not found.");
        }

        WaitingList waitingList = mapper.toEntity(requestDTO);
        waitingList.setId(id);

        return mapper.toResponseDTO(repository.save(waitingList));
    }

    @Override
    public void delete(Long id) {

        if (!isExist(id)) {
            throw new EntityNotFoundException("Waiting list not found.");
        }
        repository.deleteById(id);
    }

    @Override
    public Page<WaitingListResponseDTO> readAll(int page , int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<WaitingList> waitingLists = repository.findAll(pageable);
        return waitingLists.map(mapper::toResponseDTO);

    }

    @Override
    public WaitingListResponseDTO read(Long id) {
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Waiting list not found.")));
    }
}
