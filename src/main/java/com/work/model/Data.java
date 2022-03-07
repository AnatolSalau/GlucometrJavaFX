package com.work.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Data implements Serializable {

    private int idLow;
    private int idHigh;
    private LocalDate date;
    private LocalTime time;
    private int diary;
    private int eat;
    private float glucose;
    private float hct;

    public Data() {
    }

    public Data(int idLow, int idHigh, LocalDate date, LocalTime time, int diary, int eat, float glucose, float hct) {
        this.idLow = idLow;
        this.idHigh = idHigh;
        this.date = date;
        this.time = time;
        this.diary = diary;
        this.eat = eat;
        this.glucose = glucose;
        this.hct = hct;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getIdLow() {
        return idLow;
    }

    public void setIdLow(int idLow) {
        this.idLow = idLow;
    }

    public int getIdHigh() {
        return idHigh;
    }

    public void setIdHigh(int idHigh) {
        this.idHigh = idHigh;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDiary() {
        return diary;
    }

    public void setDiary(int diary) {
        this.diary = diary;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public float getGlucose() {
        return glucose;
    }

    public void setGlucose(float glucose) {
        this.glucose = glucose;
    }

    public float getHct() {
        return hct;
    }

    public void setHct(float hct) {
        this.hct = hct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return getIdLow() == data.getIdLow() &&
                getIdHigh() == data.getIdHigh() &&
                getDiary() == data.getDiary() &&
                getEat() == data.getEat() &&
                getGlucose() == data.getGlucose() &&
                getHct() == data.getHct() &&
                Objects.equals(getDate(), data.getDate()) &&
                Objects.equals(getTime(), data.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLow(), getIdHigh(), getDate(), getTime(), getDiary(), getEat(), getGlucose(), getHct());
    }

    @Override
    public String toString() {
        return "Data { " +
                "idLow = " + idLow +
                ", idHigh = " + idHigh +
                ", dayOfMonth = " + date.getDayOfMonth() +
                ", month = " + date.getMonth() +
                ", year = " + date.getYear() +
                ", hour = " + time.getHour() +
                ", minute = " + time.getMinute() +
                ", diary = " + diary +
                ", eat = " + eat +
                ", glucose = " + glucose +
                ", hct = " + hct +
                " }";
    }
}
