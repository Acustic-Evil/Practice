package com.example.praktika.repository;

import com.example.praktika.entity.AdminEntity;
import com.example.praktika.entity.InstrumentEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InstrumentRepository implements IInstrumentRepository {

    private final static String Ins_FILE_PATH = "src/main/resources/data_files/instruments.json";

    private final String FILE_PATH_forID = "data_files/instruments.json";
    ClassPathResource resource = new ClassPathResource(FILE_PATH_forID);
    InputStream inputStream = resource.getInputStream();
    ObjectMapper objectMapper = new ObjectMapper();

    public InstrumentRepository() throws IOException {
    }

    private final AtomicInteger lastId = new AtomicInteger(Math.toIntExact(getLastInstrumentId()));

    @Async
    public int generateId() {
        return lastId.incrementAndGet();
    }

    @Async
    public Long getLastInstrumentId() {
        Long lastId = (long) -1;

        try {
            List<InstrumentEntity> instruments = objectMapper.readValue(inputStream, new TypeReference<>() {
            });

            if (!instruments.isEmpty()) {
                InstrumentEntity lastAdmin = instruments.get(instruments.size() - 1);
                lastId = lastAdmin.getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId;
    }

    @Async
    @Override
    public List<InstrumentEntity> findAllInstruments() {
        try {
            return objectMapper.readValue(new File(Ins_FILE_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Async
    @Override
    public InstrumentEntity save(InstrumentEntity instrument) {
        try {
            List<InstrumentEntity> instruments = objectMapper.readValue(new File(Ins_FILE_PATH), new TypeReference<>() {
            });
            if (instrument.getId() == null) {
                instrument.setId((long) generateId());
            }
            instruments.add(instrument);
            objectMapper.writeValue(new File(Ins_FILE_PATH), instruments);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instrument;
    }

    @Async
    @Override
    public InstrumentEntity findByName(String instrument_name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<InstrumentEntity> instruments = objectMapper.readValue(new File(Ins_FILE_PATH), new TypeReference<>() {
            });
            return instruments.stream().filter(a -> a.getInstrument_name().equals(instrument_name)).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Async
    @Override
    public void update(InstrumentEntity instrument) {
        List<InstrumentEntity> instruments = findAllInstruments();
        for (int i = 0; i < instruments.size(); i++) {
            if (Objects.equals(instruments.get(i).getId(), instrument.getId())) {
                instruments.set(i, instrument);
                break;
            }
        }
        try {
            objectMapper.writeValue(new File(Ins_FILE_PATH), instruments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    @Override
    public void delete(Long id) {
        List<InstrumentEntity> instruments = findAllInstruments();
        instruments.removeIf(instrument -> Objects.equals(instrument.getId(), id));
        System.out.println();
        try {
            objectMapper.writeValue(new File(Ins_FILE_PATH), instruments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    @Override
    public InstrumentEntity findById(Long id) {
        List<InstrumentEntity> instruments = findAllInstruments();
        for (InstrumentEntity instrument : instruments) {
            if (instrument.getId() == id) {
                return instrument;
            }
        }
        return null;
    }
}
