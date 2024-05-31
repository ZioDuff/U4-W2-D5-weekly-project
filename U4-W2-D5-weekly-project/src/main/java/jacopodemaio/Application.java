package jacopodemaio;


import jacopodemaio.entities.Archivio;
import jacopodemaio.entities.Libro;
import jacopodemaio.entities.Rivista;
import jacopodemaio.enums.Periodicità;

public class Application {

    public static void main(String[] args) {

        System.out.println("----Creazione Archivio----");
        System.out.println();

        Archivio archivio = new Archivio();
        archivio.createAll(10, 10);

        System.out.println(archivio);
        System.out.println();


        System.out.println("---Aggiunta Libri e Riviste----");
        System.out.println();

        Libro myBook = new Libro("Sono me stesso", 2024, 20, "Jacopo", "Autoriale");
        archivio.addBook(myBook);

        Rivista myMagazine = new Rivista("Chi", 2023, 12, Periodicità.SETTIMANLE);
        archivio.addMagazine(myMagazine);

        System.out.println(archivio);
        System.out.println();


        System.out.println("----Rimuovere dall'archivio tramite il codice ISBN");
        System.out.println();

//        essendo il codice isbn un random con valori troppo alti (mea culpa) ho direttamente preso il mio isbn per provare se funziona
        archivio.removeBookFromIsbn(myBook.getISBN());
//        System.out.println(archivio);

        archivio.removeMagazineFromIsbn(myMagazine.getISBN());
//        System.out.println(archivio);


//        stesso discorso per l'esercizio di prima
        System.out.println("----Ricerca per ISBN----");
        System.out.println();

        archivio.searchBookByIsbn(myBook.getISBN());

        archivio.searchMagazineByIsbn(myMagazine.getISBN());


        System.out.println("----Ricerca per anno----");


        archivio.groupingBooksByYear(1999);

        archivio.groupingMagazineByYear(2004);

        System.out.println();


    }


}
