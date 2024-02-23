package ru.otus.hw_28_feb.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw_28_feb.entities.Book;

@Repository
public interface BookRepository  extends PagingAndSortingRepository<Book, Long> {

    Page<Book> findAllById(Long id, Pageable pageable);
}

