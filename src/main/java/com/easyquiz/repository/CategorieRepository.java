package com.easyquiz.repository;

import com.easyquiz.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 19/01/2018.
 */
public interface CategorieRepository   extends JpaRepository<Categorie, Integer> {
}
