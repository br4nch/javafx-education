/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.DatePicker;

/**
 *
 * @author Le Tam
 */
public class User {

    private Object _id;
    private String username;
    private String password;
    private String email;
    private String dob;

    public User() {
    }

    public User(Object _id, String username, String password, String email, String dob) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    /**
     * @return the _id
     */
    public Object getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(Object _id) {
        this._id = _id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the f
     */
    public String getDOB() {
        return dob;
    }

    /**
     * @param dob the phone to set
     */
    public void setDOB(String dob) {
        this.dob = dob;
    }

}
