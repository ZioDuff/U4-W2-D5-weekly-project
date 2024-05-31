package jacopodemaio.entities;

import java.util.Random;

public abstract class OggettoLibreria {
    //    ATTRIBUTI
    protected Long ISBN = new Random().nextLong(10000, 90000);
    protected String title;
    protected int yearPublication;
    protected int numOfPages;
//    COSTRUTTORE

    public OggettoLibreria(String title, int yearPublication, int numOfPages) {

        this.title = title;
        this.yearPublication = yearPublication;
        this.numOfPages = numOfPages;
    }

//    METODI

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }


}
