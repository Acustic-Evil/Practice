package com.example.praktika.entity;

public class InstrumentEntity {
    private Integer id;

/*    public String chord;*/

    public String instrument_name;

    public Integer num_of_strings;

    public String factory_number;

    public String factory_name;

    public InstrumentEntity() {
    }

    public InstrumentEntity(/*String chord,*/ String instrument_name, Integer num_of_strings, String factory_number, String factory_name) {
        /*this.chord = chord;*/
        this.instrument_name = instrument_name;
        this.num_of_strings = num_of_strings;
        this.factory_number = factory_number;
        this.factory_name = factory_name;
    }

    public InstrumentEntity(Integer id, String instrument_name, Integer num_of_strings, String factory_number, String factory_name) {
        this.id = id;
        this.instrument_name = instrument_name;
        this.num_of_strings = num_of_strings;
        this.factory_number = factory_number;
        this.factory_name = factory_name;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }*/



    public Integer getNum_of_strings() {
        return num_of_strings;
    }

    public void setNum_of_strings(Integer num_of_strings) {
        this.num_of_strings = num_of_strings;
    }

    public String getFactory_number() {
        return factory_number;
    }

    public void setFactory_number(String factory_number) {
        this.factory_number = factory_number;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }
}
