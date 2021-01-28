package day09flightsdb;

import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flight {

    private int id;
    private Date onDay;
    private String fromCode;
    private String toCode;
    private Type type;
    private int passengers;

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    enum Type {
        Domestic, International, Private
    }

    public Flight(int id, Date onDay, String fromCode, String toCode, Type type, int passengers) throws InvalidDataException {
        setId(id);
        setOnDay(onDay);
        setFromCode(fromCode);
        setToCode(toCode);
        setType(type);
        setPassengers(passengers);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOnDay() {
        return onDay;
    }

    public void setOnDay(Date onDay) throws InvalidDataException {
        try {
            if (onDay.before(dateFormat.parse("01-01-1970")) || onDay.after(dateFormat.parse("01-01-2100"))) {
                throw new InvalidDataException("dueDate must be between 1970 and 2100");
            }
            this.onDay = onDay;
        } catch (ParseException ex) {
            throw new InvalidDataException("Internal error, failed to parse date", ex);
        }
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) throws InvalidDataException {
        fromCode = fromCode.toUpperCase();
        if (!fromCode.matches("[A-Z]{3,5}")) {
            throw new InvalidDataException("Code must be 3-5 characters");
        }
        this.fromCode = fromCode.toUpperCase();
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) throws InvalidDataException {
        fromCode = fromCode.toUpperCase();
        if (!fromCode.matches("[A-Z]{3,5}")) {
            throw new InvalidDataException("Code must be 3-5 characters");
        }
        this.toCode = toCode.toUpperCase();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) throws InvalidDataException {
        if (passengers < 0 || passengers > 200) {
            throw new InvalidDataException("Passengers must be 0-200");
        }
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return String.format("id=%d, onDay=%s, fromCode=%s, toCode=%s, type=%s, passengers=%d",
                id, dateFormat.format(onDay), fromCode, toCode, type.toString(), passengers);

    }

    public String toDataLine() {

        return String.format("%d;%s;%s;%s;%s;%d",
                id, dateFormat.format(onDay), fromCode, toCode, type.toString(), passengers);

    }

}
