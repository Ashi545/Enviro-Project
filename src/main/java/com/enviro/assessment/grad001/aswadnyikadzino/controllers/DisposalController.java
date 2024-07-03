package com.enviro.assessment.grad001.aswadnyikadzino.controllers;

import com.enviro.assessment.grad001.aswadnyikadzino.models.DisposalGuideline;
import com.enviro.assessment.grad001.aswadnyikadzino.models.WasteCategory;
import com.enviro.assessment.grad001.aswadnyikadzino.repositories.DisposalRepo;
import com.enviro.assessment.grad001.aswadnyikadzino.repositories.WasteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalController {

    @Autowired
    private DisposalRepo disposalRepo;

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllTips(){
        try {
            List<DisposalGuideline> disposalList = new ArrayList<>();
            disposalRepo.findAll().forEach(disposalList::add);

            if (disposalList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(disposalList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getTipById(@PathVariable Long id){
        Optional<DisposalGuideline> disposal = disposalRepo.findById(id);
        if (disposal.isPresent()) {
            return new ResponseEntity<>(disposal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> addTip(@RequestBody DisposalGuideline disposal){
        try {
            DisposalGuideline disposal1 = disposalRepo.save(disposal);
            return new ResponseEntity<>(disposal1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<DisposalGuideline> updateTipById(@PathVariable Long id, @RequestBody DisposalGuideline disposal){
        return disposalRepo.findById(id)
                .map(existingDisposalGuideline -> {
                    disposal.setId(id);
                    return new ResponseEntity<>(disposalRepo.save(disposal), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(("{id}"))
    public ResponseEntity<WasteCategory> deleteTip(@PathVariable long id){
        if (disposalRepo.findById(id).isPresent()) {
            disposalRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
