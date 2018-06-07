package com.easyquiz.service;

import com.easyquiz.model.Disipline;

import java.util.List;

/**
 * Created by felleuch on 23/02/2018.
 */
public interface DisiplineService {
    Disipline create(Disipline disipline);
    Disipline delete(int id) throws Exception;
    List<Disipline> findAll();
    Disipline update(Disipline disipline) throws Exception;
    Disipline findById(int id);
}
