package jacopodemaio.entities;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
        Supplier<Libro> booksSupplier = () -> new Libro(faker.book().title(), faker.number().numberBetween(2000, 2024), faker.number().numberBetween(80, 2000), faker.book().author(), faker.book().genre());
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


    public void removeObjectByIsbn(String str, long isbn) {
        if (str.equals("Libro")) {
            archivioLibri.removeIf(e -> e.getISBN() == isbn);
            System.out.println("Libro rimosso");
        } else if (str.equals("Rivista")) {
            archivioRiviste.removeIf(e -> e.getISBN() == isbn);
            System.out.println("Rivista rimosso");
        } else System.out.println("Non hai rimosso nulla...");
    }

    public void searchBookByIsbn(long isbn) {
        Optional<OggettoLibreria> bookFounded = archivioLibri.stream().filter(book -> book.getISBN() == isbn).findFirst();
        if (bookFounded.isPresent()) {
            System.out.println("trovato " + bookFounded.get());
        } else {
            System.out.println("non trovato");
        }
    }

    public void searchMagazineByIsbn(long isbn) {
        Optional<OggettoLibreria> magazineFounded = archivioRiviste.stream().filter(book -> book.getISBN() == isbn).findFirst();
        if (magazineFounded.isPresent()) {
            System.out.println("trovato " + magazineFounded.get());
        } else {
            System.out.println("non trovato");
        }
    }

    public void groupingBooksByYear(int year) {
        Map<String, List<OggettoLibreria>> booksByYear = archivioLibri.stream().filter(book -> book.getYearPublication() == year).collect(Collectors.groupingBy(book -> book.getTitle()));
        if (booksByYear.isEmpty()) {
            System.out.println("Nessun libro per l'anno " + year);
        } else {
            System.out.println("queste sono i libri in base a l'anno cercato:");
            booksByYear.forEach((yearPublication, title) -> System.out.println("anno " + year + " " + title));
        }
    }

    public void groupingMagazineByYear(int year) {
        Map<String, List<OggettoLibreria>> magazineByYear = archivioRiviste.stream().filter(magazine -> magazine.getYearPublication() == year).collect(Collectors.groupingBy(magazine -> magazine.getTitle()));
        if (magazineByYear.isEmpty()) {
            System.out.println("Nessuna rivista per l'anno " + year);
        } else {
            System.out.println("queste sono le riviste in base a l'anno cercato:");
            magazineByYear.forEach((yearPublication, title) -> System.out.println("anno " + year + " " + title));

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
