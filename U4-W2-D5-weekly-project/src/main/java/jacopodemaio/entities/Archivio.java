package jacopodemaio.entities;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Archivio {
    //    ATTRIBUTI
    private List<OggettoLibreria> archivioLibri;
    private List<OggettoLibreria> archivioRiviste;
//    COSTRUTTORE

    public Archivio() {
        this.archivioLibri = archivioLibri = new ArrayList<>();
        this.archivioRiviste = archivioRiviste = new ArrayList<>();
    }

    //    METODI

    //    qui vado a generare i le liste di libri e riviste con dei metodi
    public static void generateBooks(int total, List<OggettoLibreria> archivioLibri) {
        Faker faker = new Faker();
        Supplier<Libro> booksSupplier = () -> new Libro(faker.book().title(), faker.number().numberBetween(1800, 2024), faker.number().numberBetween(80, 2000), faker.book().author(), faker.book().genre());
        for (int i = 0; i < 10; i++) {
            archivioLibri.add(booksSupplier.get());
        }
    }

    public static void generateMagazines(int total, List<OggettoLibreria> archivioRiviste) {
        Faker faker = new Faker();
        Supplier<Rivista> magazinesSupplier = () -> new Rivista(faker.book().title(), faker.number().numberBetween(2000, 2024), faker.number().numberBetween(20, 200), Rivista.getRandomPeriods());
        for (int i = 0; i < 10; i++) {
            archivioRiviste.add(magazinesSupplier.get());
        }


    }

    public void createAll(int bookAmount, int magazineAmount) {
        generateBooks(bookAmount, archivioLibri);
        generateMagazines(magazineAmount, archivioRiviste);
    }


    public void addBook(OggettoLibreria book) {
        archivioLibri.add(book);
        System.out.println(book.getTitle() + " Il tuo libro è stato aggiunto");
    }

    public void addMagazine(OggettoLibreria magazine) {
        archivioRiviste.add(magazine);
        System.out.println(magazine.getTitle() + " La tua rivista è stata aggiunta");
    }

    public void removeBookFromIsbn(long isbn) {
        archivioLibri.removeIf(book -> book.getISBN() == isbn);
        System.out.println("Libro rimosso con successo");
    }

    public void removeMagazineFromIsbn(long isbn) {
        archivioRiviste.removeIf(magazine -> magazine.getISBN() == isbn);
        System.out.println("Rivista eliminata con successo");
    }

    public void seachBookByIsbn(long isbn) {
        Optional<OggettoLibreria> bookFounded = archivioLibri.stream().filter(book -> book.getISBN() == isbn).findFirst();
        if (bookFounded.isPresent()) {
            System.out.println("trovato" + bookFounded.get());
        } else {
            System.out.println("non trovato");
        }
    }


    @Override
    public String toString() {
        return "Archivio{" +
                "archivioLibri=" + archivioLibri +
                ", archivioRiviste=" + archivioRiviste +
                '}';
    }

}
