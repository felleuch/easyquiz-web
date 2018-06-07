package com.easyquiz.repository;

import com.easyquiz.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 22/01/2018.
 */
public interface QuestionRepository  extends JpaRepository<Question, Integer> {
}
