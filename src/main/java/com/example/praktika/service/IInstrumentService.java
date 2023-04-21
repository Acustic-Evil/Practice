package com.example.praktika.service;

import com.example.praktika.entity.InstrumentEntity;

import java.util.List;

public interface IInstrumentService {


    List<InstrumentEntity> findAllInstruments();

/*
    InstrumentEntity addNewInstrument(String instrument_name, Integer num_of_strings, String factory_name, String factory_number);
*/
    InstrumentEntity addNewInstrument(InstrumentEntity instrument);
    InstrumentEntity saveInstrument(InstrumentEntity admin);

    InstrumentEntity findById(Long id);
    InstrumentEntity update(InstrumentEntity instrument);

    void delete(Long id);


}
