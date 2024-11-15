package ma.youcode.wrm.controller;

import jakarta.validation.Valid;
import ma.youcode.wrm.dto.SuccessDTO;
import ma.youcode.wrm.dto.request.visit.VisitCreateDTO;
import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import ma.youcode.wrm.services.implementations.VisitServiceImpl;
import ma.youcode.wrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    @Autowired
    private VisitServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDTO> getVisit(@PathVariable Long id ) {
        VisitResponseDTO responseDTO = service.read(id);
        return Response.success(200 , "Visit has been successfully retrieved." , "visit" , responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<SuccessDTO> getAllVisits(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size ) {
        Page<VisitResponseDTO> responseDTO = service.readAll(page , size);
        return Response.success(200 , "All Visits has been successfully retrieved." , "visits" , responseDTO);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> addNewVisit(@Valid @RequestBody VisitCreateDTO requestDTO) {
        VisitResponseDTO responseDTO = service.create(requestDTO);
        return Response.success(201 , "Visit has been successfully created." , "visit" , responseDTO);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<SuccessDTO> editVisit(@Valid @RequestBody VisitUpdateDTO requestDTO , @PathVariable Long id) {
        VisitResponseDTO responseDTO = service.update(requestDTO , id);
        return Response.success(200 , "Visit has been successfully updated." , "visit" , responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessDTO> deleteVisit(@PathVariable Long id) {
        service.delete(id);
        return Response.success(200 , "Visit has been successfully deleted.");
    }

}
