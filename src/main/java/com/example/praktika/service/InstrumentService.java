package com.example.praktika.service;

import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService implements IInstrumentService {
    @Autowired
    InstrumentRepository instrumentRepository;

    @Override
    public List<InstrumentEntity> findAllInstruments() {
        return instrumentRepository.findAllInstruments();
    }

    @Async
    @Override
    public InstrumentEntity addNewInstrument(InstrumentEntity instrument) {
        /*InstrumentEntity instrument = new InstrumentEntity(instrument_name, num_of_strings, factory_name, factory_number);*/
        return saveInstrument(instrument);
    }

    @Async
    @Override
    public InstrumentEntity saveInstrument(InstrumentEntity instrument) {
        if (instrument.getInstrument_name() == null) {
            throw new IllegalArgumentException("One or more fields are null");
        }
        return instrumentRepository.save(instrument);
    }

    @Async
    @Override
    public InstrumentEntity findById(Long id) {
        return instrumentRepository.findById(id);
    }

    @Async
    @Override
    public void delete(Long id) {
        instrumentRepository.delete(id);
    }

    @Async
    public InstrumentEntity update(InstrumentEntity instrument) {
        instrumentRepository.update(instrument);
        return instrumentRepository.findById(instrument.getId());
    }


}
