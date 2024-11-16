package ma.youcode.wrm.controller;

import jakarta.validation.Valid;
import ma.youcode.wrm.dto.request.waitingList.WaitingListCreateDTO;
import ma.youcode.wrm.dto.SuccessDTO;
import ma.youcode.wrm.dto.request.waitingList.WaitingListUpdateDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListResponseDTO;
import ma.youcode.wrm.services.interfaces.WaitingListService;
import ma.youcode.wrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/waiting-list")
public class WaitingListController {

    @Autowired
    private WaitingListService service;

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDTO> getWaitingList(@PathVariable Long id) {
        WaitingListResponseDTO responseDTO = service.read(id);
        return Response.success(200 , "waiting list has been successfully retrieved." , "waiting-list" , responseDTO);
    }
    @GetMapping("/{id}/sorted")
    public ResponseEntity<SuccessDTO> getWaitingListWithSorted(@PathVariable Long id) {
        WaitingListResponseDTO responseDTO = service.readWithSortedVisits(id);
        return Response.success(200 , "sorted waiting list has been successfully retrieved." , "waiting-list" , responseDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<SuccessDTO> getAllWaitingList(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {

        Page<WaitingListResponseDTO> responseDTO = service.readAll(page, size);
        return Response.success(200 , "All waiting list has been successfully retrieved." , "waiting-lists" , responseDTO);
    }

    @GetMapping("/all/sorted")
    public ResponseEntity<SuccessDTO> getAllWithSortedVisits(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {

        Page<WaitingListResponseDTO> responseDTO = service.readAllWithSortedVisits(page, size);
        return Response.success(200 , "All sorted waiting list has been successfully retrieved." , "waiting-lists" , responseDTO);
    }
    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> addNewWaitingList(@Valid @RequestBody WaitingListCreateDTO requestDTO) {
        WaitingListResponseDTO responseDTO = service.create(requestDTO);
        return Response.success(201 , "Waiting list has been successfully created." , "waiting-list" , responseDTO);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<SuccessDTO> editWaitingList(@Valid @RequestBody WaitingListUpdateDTO requestDTO , @PathVariable Long id) {
        WaitingListResponseDTO responseDTO = service.update(requestDTO , id);
        return Response.success(200 , "Waiting list has been successfully updated." , "waiting-list" , responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessDTO> deleteWaitingList(@PathVariable Long id) {
        service.delete(id);
        return Response.success(200 , "Waiting list has been successfully deleted.");
    }


}
