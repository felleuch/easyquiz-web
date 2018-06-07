package com.easyquiz.repository;


import com.easyquiz.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface PropositionRepository  extends JpaRepository<Proposition, Integer> {

}
