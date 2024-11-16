package ma.youcode.wrm.controller;

import jakarta.validation.Valid;
import ma.youcode.wrm.dto.SuccessDTO;
import ma.youcode.wrm.dto.request.visitor.VisitorCreateDTO;
import ma.youcode.wrm.dto.request.visitor.VisitorUpdateDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorResponseDTO;
import ma.youcode.wrm.services.implementations.VisitorServiceImpl;
import ma.youcode.wrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    @Autowired
    private VisitorServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDTO> getVisitor(@PathVariable Long id ) {
        VisitorResponseDTO responseDTO = service.read(id);
        return Response.success(200 , "Visitor has been successfully retrieved." , "visitor" , responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<SuccessDTO> getAllVisitors(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size ) {
        Page<VisitorResponseDTO> responseDTO = service.readAll(page , size);
        return Response.success(200 , "All Visitors has been successfully retrieved." , "visitors" , responseDTO);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> addNewVisitor(@Valid @RequestBody VisitorCreateDTO requestDTO) {
        VisitorResponseDTO responseDTO = service.create(requestDTO);
        return Response.success(201 , "Visitor has been successfully created." , "visitor" , responseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SuccessDTO> updateVisitor(@Valid @RequestBody VisitorUpdateDTO requestDTO , @PathVariable Long id) {
        VisitorResponseDTO responseDTO = service.update(requestDTO , id);
        return Response.success(200 , "Visitor has been successfully updated." , "visitor" , responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessDTO> deleteVisitor(@PathVariable Long id) {
        service.delete(id);
        return Response.success(200 , "Visitor has been successfully deleted.");
    }

}
