package com.example.praktika.repository;

import com.example.praktika.entity.InstrumentEntity;

import java.util.List;

public interface IInstrumentRepository {

    List<InstrumentEntity> findAllInstruments();

    void save(InstrumentEntity admin);

    InstrumentEntity findByName(String instrument_name);

    InstrumentEntity findById(int id);
    void update(InstrumentEntity admin);
    void delete(Integer id);
}
