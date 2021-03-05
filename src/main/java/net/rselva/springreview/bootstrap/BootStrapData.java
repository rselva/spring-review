package net.rselva.springreview.bootstrap;


import net.rselva.springreview.model.Author;
import net.rselva.springreview.model.Book;
import net.rselva.springreview.model.Publisher;
import net.rselva.springreview.repository.AuthorRepository;
import net.rselva.springreview.repository.BookRepository;
import net.rselva.springreview.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","12345");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Jhonson");
        Book noEjb = new Book("J2EE development without EJB","54331");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjb);

        Publisher manning = new Publisher("Manning","123","Koram","Bang","1234");
        manning.getBooks().add(ddd);
        manning.getBooks().add(noEjb);
        publisherRepository.save(manning);


        System.out.println("Started in Bootstrap");
        System.out.println("No of books="+bookRepository.count());

        System.out.println("No of publishers="+publisherRepository.count());

        publisherRepository.findAll()
                .forEach(publisher -> publisher.getBooks().forEach(book -> System.out.println(book.getTitle())));

    }
}
