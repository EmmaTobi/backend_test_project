/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.exceptions;

/**
 *
 * @author emmanuelAgboola
 */
public class CarAlreadyInUseException extends Exception {

    public CarAlreadyInUseException(String message) {
        super(message);
    }
}
