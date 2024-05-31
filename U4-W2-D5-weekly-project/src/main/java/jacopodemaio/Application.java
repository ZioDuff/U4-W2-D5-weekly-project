package jacopodemaio;

import com.github.javafaker.Faker;
import jacopodemaio.entities.Libri;
import jacopodemaio.entities.Riviste;
import jacopodemaio.enums.Periodicità;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
//        supplier per rendere randomiche sia le pagine che l'anno di uscita

        Supplier<Integer> rndmyearSupplier = () -> new Random().nextInt(1970, 2024);
        Supplier<Integer> rndmNumOfPages = () -> new Random().nextInt(6, 800);


//        creiamo una lista di libri partendo dal supplier per generare un libro solo e poi tramite il loop inserirlo in una lista
        Supplier<Libri> booksSupplier = () -> {
            Faker faker = new Faker();
            return new Libri(faker.book().title(),
                    rndmyearSupplier.get(), rndmNumOfPages.get(), faker.book().author(), faker.book().genre());
        };


        List<Libri> booksList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            booksList.add(booksSupplier.get());
        }
//        booksList.forEach(System.out::println);

//        creiamo la lista di riviste

        Supplier<Periodicità> periodsSupplier = () -> {
            Periodicità[] periods = Periodicità.values();
            Random rndm = new Random();
            int index = rndm.nextInt(periods.length);
            return periods[index];

        };

        Supplier<Riviste> magazinesSupplier = () -> {
            Faker faker = new Faker();
            return new Riviste(faker.book().title(), rndmyearSupplier.get(), rndmNumOfPages.get(), periodsSupplier.get());
        };

        List<Riviste> magazinesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            magazinesList.add(magazinesSupplier.get());
        }
//        magazinesList.forEach(System.out::println);


    }


}
