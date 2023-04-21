package com.example.praktika.repository;

import com.example.praktika.entity.InstrumentEntity;

import java.util.List;

public interface IInstrumentRepository {

    List<InstrumentEntity> findAllInstruments();

    InstrumentEntity save(InstrumentEntity admin);

    InstrumentEntity findByName(String instrument_name);

    InstrumentEntity findById(Long id);
    void update(InstrumentEntity instrument);
    void delete(Long id);
}
