package com.inaal.rumahkost_api.controllers;

import com.inaal.rumahkost_api.models.dto.KostDTO;
import com.inaal.rumahkost_api.models.entity.Kost;
import com.inaal.rumahkost_api.models.response.SuccessResponse;
import com.inaal.rumahkost_api.services.IServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/kost")
public class KostController {

    private IServices<Kost> kostService;
    private ModelMapper modelMapper;

    @Autowired
    public KostController(IServices<Kost> kostService, ModelMapper modelMapper) {
        this.kostService = kostService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity getAllKost(){
        List<Kost> kosts = kostService.getAllService();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success get all kost", kosts));
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) throws Exception {
        Kost kost = kostService.getByIdService(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success get kost with id " + id, kost));
    }
    @PostMapping
    public ResponseEntity createKost(@Valid  @RequestBody KostDTO kostDTO) throws Exception {
        Kost kost = modelMapper.map(kostDTO, Kost.class);
        kostService.saveService(kost);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SuccessResponse("Success create kost", kost));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateKost(@Valid @RequestBody KostDTO kostDTO, @PathVariable Long id) throws Exception {
        Kost kost = modelMapper.map(kostDTO, Kost.class);
        kost.setId(id);
        kostService.updateService(kost);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success update kost with id " + id, kost));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteKost(@PathVariable Long id ) throws Exception {
        Kost idKost = kostService.getByIdService(id);
        kostService.deleteService(idKost);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success delete kost with id " + id, null));
    }


}
