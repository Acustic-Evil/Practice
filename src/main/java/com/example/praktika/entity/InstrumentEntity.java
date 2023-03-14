package com.example.praktika.entity;

public class InstrumentEntity {
    private Integer id;

    public String Chord;

    public InstrumentEntity() {
    }

    public String getChord() {
        return Chord;
    }

    public void setChord(String chord) {
        this.Chord = chord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
