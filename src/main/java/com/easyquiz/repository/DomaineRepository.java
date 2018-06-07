package com.easyquiz.repository;

import com.easyquiz.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 19/01/2018.
 */
public interface DomaineRepository extends JpaRepository<Domaine, Integer> {
}
