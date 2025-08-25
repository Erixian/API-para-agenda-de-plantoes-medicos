package me.erixian.controller;
import me.erixian.controller.dto.MedicalShiftRequestDto;
import me.erixian.controller.dto.MedicalShiftResponseDto;
import me.erixian.domain.model.MedicalShift;
import me.erixian.service.MedicalShiftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medical-shifts")
public class MedicalShiftController {

    private final MedicalShiftService medicalShiftService;

    public MedicalShiftController(MedicalShiftService medicalShiftService) {
        this.medicalShiftService = medicalShiftService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalShiftResponseDto> findById(@PathVariable Long id) {
        var medicalShift = medicalShiftService.findById(id);
        return ResponseEntity.ok(new MedicalShiftResponseDto(medicalShift));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<MedicalShiftResponseDto>> findShiftsByDoctorId(@PathVariable Long doctorId) {
        var shifts = medicalShiftService.findShiftsByDoctorId(doctorId);
        var shiftsDto = shifts.stream().map(MedicalShiftResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(shiftsDto);
    }

    @PostMapping
    public ResponseEntity<MedicalShiftResponseDto> create(@RequestBody MedicalShiftRequestDto requestDto) {
        var medicalShiftCreated = medicalShiftService.create(requestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicalShiftCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(new MedicalShiftResponseDto(medicalShiftCreated));
    }

}
