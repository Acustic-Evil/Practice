package com.example.praktika.service;

import com.example.praktika.entity.InstrumentEntity;

import java.util.List;

public interface IInstrumentService {


    List<InstrumentEntity> findAllInstruments();

    boolean addNewInstrument(String instrument_name, Integer num_of_strings, String factory_number, String factory_name);

    boolean saveInstrument(InstrumentEntity admin);

    InstrumentEntity findById(int id);

    void delete(Integer id);
}
