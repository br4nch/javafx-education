/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.bson.types.ObjectId;

/**
 *
 * @author Le Tam
 */
public class Course {

    
    private ObjectId _id;
    private String name;
    private String type;
    private Double duration;
    private String content;
    private String author;
    private String price;

    public Course() {
    }

    public Course(ObjectId _id, String name, String type, Double duration,
            String content, String author, String price) {
        this._id = _id;
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.content = content;
        this.author = author;
        this.price = price;
    }

    /**
     * @return the _id
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

}
