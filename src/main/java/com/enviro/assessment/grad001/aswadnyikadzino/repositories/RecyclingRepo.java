package com.enviro.assessment.grad001.aswadnyikadzino.repositories;

import com.enviro.assessment.grad001.aswadnyikadzino.models.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingRepo extends JpaRepository<RecyclingTip,Long> {

}
