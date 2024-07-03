package com.enviro.assessment.grad001.aswadnyikadzino.controllers;

import com.enviro.assessment.grad001.aswadnyikadzino.models.RecyclingTip;
import com.enviro.assessment.grad001.aswadnyikadzino.repositories.RecyclingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingController {

    @Autowired
    private RecyclingRepo recyclingRepo;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips(){
        try {
            List<RecyclingTip> tipList = new ArrayList<>();
            recyclingRepo.findAll().forEach(tipList::add);

            if (tipList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tipList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id){
        Optional<RecyclingTip> tip = recyclingRepo.findById(id);
        if (tip.isPresent()) {
            return new ResponseEntity<>(tip.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> addTip(@RequestBody RecyclingTip tip){
        try {
            RecyclingTip tip1 = recyclingRepo.save(tip);
            return new ResponseEntity<>(tip1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<RecyclingTip> updateTipById(@PathVariable Long id, @RequestBody RecyclingTip recyclingTip){
        return recyclingRepo.findById(id)
                .map(existingRecyclingTip -> {
                    recyclingTip.setId(id);
                    return new ResponseEntity<>(recyclingRepo.save(recyclingTip), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(("{id}"))
    public ResponseEntity<RecyclingTip> deleteTip(@PathVariable long id){
        if (recyclingRepo.findById(id).isPresent()) {
            recyclingRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
