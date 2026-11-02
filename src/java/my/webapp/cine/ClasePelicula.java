/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.cine;

/**
 *
 * @author Administrador
 */
public class ClasePelicula {

    private int id;
    private String title;
    private String director;
    private int year;
    private String imageUrl;

    public ClasePelicula(int id, String title, String director, int year, String imageUrl) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public ClasePelicula() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    
    

}
