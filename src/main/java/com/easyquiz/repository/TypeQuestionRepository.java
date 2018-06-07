package com.easyquiz.repository;


import com.easyquiz.model.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 23/01/2018.
 */
public interface TypeQuestionRepository extends JpaRepository<TypeQuestion, Integer> {
}
