package com.example.praktika.service;

import com.example.praktika.entity.InstrumentEntity;
import com.example.praktika.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService implements IInstrumentService {
    @Autowired
    InstrumentRepository instrumentRepository;
    @Override
    public List<InstrumentEntity> findAllInstruments(){
        return instrumentRepository.findAllInstruments();
    }

    @Override
    public boolean addNewInstrument(String instrument_name, Integer num_of_strings, String factory_number, String factory_name){
        if(!saveInstrument(new InstrumentEntity(instrument_name, num_of_strings, factory_number, factory_name))){
            return false;
        }
        System.out.println("New Instrument: " + instrument_name + "Strings: " + num_of_strings + "\nFactory: " + factory_name + ":" + factory_number);
        return true;
    }

    @Override
    public boolean saveInstrument(InstrumentEntity instrument){
        InstrumentEntity instrumentFromJson = instrumentRepository.findByName(instrument.getInstrument_name());

        if(instrumentFromJson!=null) {
            return false;
        }
        instrumentRepository.save(instrument);
        return true;
    }

    @Override
    public InstrumentEntity findById(int id) {
        return instrumentRepository.findById(id);
    }

    @Override
    public void delete(Integer id){
        instrumentRepository.delete(id);
    }
}
