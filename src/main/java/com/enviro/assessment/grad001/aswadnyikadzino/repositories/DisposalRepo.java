package com.enviro.assessment.grad001.aswadnyikadzino.repositories;

import com.enviro.assessment.grad001.aswadnyikadzino.models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalRepo extends JpaRepository<DisposalGuideline, Long> {
}
