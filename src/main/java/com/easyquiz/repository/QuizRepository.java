package com.easyquiz.repository;


import com.easyquiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
