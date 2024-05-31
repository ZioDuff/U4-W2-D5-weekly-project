package jacopodemaio.entities;


public class Libri extends Catalogo {
    //    ATTRIBUTI
    private String authors;
    private String type;
//    COSTRUTTORE

    public Libri(String title, int yearPublication, int numOfPages, String authors, String type) {
        super(title, yearPublication, numOfPages);
        this.authors = authors;
        this.type = type;
    }

//    METODI

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "authors='" + authors + '\'' +
                ", type='" + type + '\'' +
                ", ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", numOfPages=" + numOfPages +
                ", yearPublication=" + yearPublication +
                '}';
    }


}
