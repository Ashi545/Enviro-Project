package com.enviro.assessment.grad001.aswadnyikadzino.repositories;

import com.enviro.assessment.grad001.aswadnyikadzino.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WasteRepo extends JpaRepository<WasteCategory,Long> {
}
