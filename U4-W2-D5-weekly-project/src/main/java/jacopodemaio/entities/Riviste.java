package jacopodemaio.entities;

import jacopodemaio.enums.Periodicità;

public class Riviste extends Catalogo {
    //    ATTRIBUTI
    private Periodicità periodicità;
    //    COSTRUTTORE

    public Riviste(String title, int yearPublication, int numOfPages, Periodicità periodicità) {
        super(title, yearPublication, numOfPages);
        this.periodicità = periodicità;
    }

    //    METODI

    public Periodicità getPeridiodicità() {
        return periodicità;
    }

    public void setPeridiodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "peridiodicità=" + periodicità +
                ", ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                ", numOfPages=" + numOfPages +
                '}';
    }

}
