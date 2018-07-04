/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

/**
 *
 * @author kent
 */
public class Author {

    private String name;
    private String title;

//Constructor
    public Author() {
    }

    public Author(String name, String title) {
        setName(name);
        setTitle(title);
    }
    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", title=" + title + '}';
    }

}
