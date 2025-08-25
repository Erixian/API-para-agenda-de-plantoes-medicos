package me.erixian.controller;

import me.erixian.controller.dto.HospitalDto;
import me.erixian.domain.model.Hospital;
import me.erixian.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable Long id){
        var hospital = hospitalService.findById(id);
        return ResponseEntity.ok(hospital);
    }

    @PostMapping()
    public ResponseEntity<HospitalDto> create(@RequestBody HospitalDto hospitalToCreate){
        var hospitalCreated =  hospitalService.create(hospitalToCreate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hospitalCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(new HospitalDto(hospitalCreated));
    }
}
