package ma.youcode.wrm.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.dto.request.waitingList.WaitingListCreateDTO;
import ma.youcode.wrm.dto.request.waitingList.WaitingListUpdateDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import ma.youcode.wrm.mappers.WaitingListMapper;
import ma.youcode.wrm.repositories.WaitingListRepository;
import ma.youcode.wrm.services.interfaces.WaitingListService;
import ma.youcode.wrm.utils.DefaultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public WaitingListResponseDTO create(WaitingListCreateDTO requestDTO) {

        WaitingList waitingList = mapper.fromCreateDTO(requestDTO);
        DefaultHandler.waitingListDefaults(waitingList);
        return mapper.toResponseDTO(repository.save(waitingList));

    }

    @Override
    public WaitingListResponseDTO update(WaitingListUpdateDTO requestDTO, Long id) {

        if (!isExist(id)) {
            throw new EntityNotFoundException("Waiting list not found.");
        }

        WaitingList waitingList = mapper.fromUpdateDTO(requestDTO);
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
