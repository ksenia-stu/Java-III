/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09flightsdb;


public class InvalidDataException extends Exception {

    public InvalidDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidDataException(String msg) {
        super(msg);
    }

    public InvalidDataException() {
    }

}
