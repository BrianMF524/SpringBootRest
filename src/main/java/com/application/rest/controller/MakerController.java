package com.application.rest.controller;

import com.application.rest.controller.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/find")
    private ResponseEntity<?> findAll(){
        List<MakerDTO> makerDTOList =makerService.findAll().stream()
                .map(maker-> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerDTOList);
    }

    @GetMapping("/find/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional= makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker=makerOptional.get();
            MakerDTO makerDTO=MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    private ResponseEntity<?> saveMaker(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if(!makerDTO.getName().isEmpty()){
            makerService.save(Maker.builder()
                    .name(makerDTO.getName())
                    .build());
            ResponseEntity.created(new URI("/api/maker/save")).build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateMaker(@RequestBody MakerDTO makerDTO,@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker =makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteMaker(@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()){
            makerService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
