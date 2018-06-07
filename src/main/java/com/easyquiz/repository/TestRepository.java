package com.easyquiz.repository;


import com.easyquiz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by felleuch on 22/01/2018.
 */
public interface TestRepository  extends JpaRepository<Test, Integer> {



}
