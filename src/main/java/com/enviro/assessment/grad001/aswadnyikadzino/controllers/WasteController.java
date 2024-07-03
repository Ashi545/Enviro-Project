package com.enviro.assessment.grad001.aswadnyikadzino.controllers;

import com.enviro.assessment.grad001.aswadnyikadzino.models.RecyclingTip;
import com.enviro.assessment.grad001.aswadnyikadzino.models.WasteCategory;
import com.enviro.assessment.grad001.aswadnyikadzino.repositories.RecyclingRepo;
import com.enviro.assessment.grad001.aswadnyikadzino.repositories.WasteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteController {


    @Autowired
    private WasteRepo wasteRepo;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllTips(){
        try {
            List<WasteCategory> wasteList = new ArrayList<>();
            wasteRepo.findAll().forEach(wasteList::add);

            if (wasteList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(wasteList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getTipById(@PathVariable Long id){
        Optional<WasteCategory> waste= wasteRepo.findById(id);
        if (waste.isPresent()) {
            return new ResponseEntity<>(waste.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> addTip(@RequestBody WasteCategory wasteCategory){
        try {
            WasteCategory wasteCategory1 = wasteRepo.save(wasteCategory);
            return new ResponseEntity<>(wasteCategory1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<WasteCategory> updateTipById(@PathVariable Long id, @RequestBody WasteCategory wasteCategory){
        return wasteRepo.findById(id)
                .map(existingWasteCategory -> {
                    wasteCategory.setId(id);
                    return new ResponseEntity<>(wasteRepo.save(wasteCategory), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(("{id}"))
    public ResponseEntity<WasteCategory> deleteTip(@PathVariable long id){
        if (wasteRepo.findById(id).isPresent()) {
            wasteRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
