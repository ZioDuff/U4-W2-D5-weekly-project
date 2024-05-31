package jacopodemaio.entities;

import jacopodemaio.enums.Periodicità;

import java.util.Random;

public class Rivista extends OggettoLibreria {
    //    ATTRIBUTI
    private Periodicità periodicità;
    //    COSTRUTTORE

    public Rivista(String title, int yearPublication, int numOfPages, Periodicità periodicità) {
        super(title, yearPublication, numOfPages);
        this.periodicità = periodicità;
    }

    //    METODI

    public static Periodicità getRandomPeriods() {
        Periodicità[] periods = Periodicità.values();
        Random rndm = new Random();
        int index = rndm.nextInt(periods.length);
        return periods[index];
    }

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
