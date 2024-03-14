package ru.otus.hw_28_feb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.hw_28_feb.dtos.CommentBookDto;
import ru.otus.hw_28_feb.dtos.PageDtoPagination;
import ru.otus.hw_28_feb.entities.Book;
import ru.otus.hw_28_feb.repositories.BookPaginationRepository;


import java.util.List;
import java.util.Optional;

@Service
public class PageService {
    private final BookPaginationRepository repository;

    @Autowired
    public PageService(BookPaginationRepository repository) {
        this.repository = repository;
    }

    public List<PageDtoPagination> pageDtoPaginationByFormat(long id) {
         return repository.getPageByFormatId(id);
    }

    public List<CommentBookDto> getBookRating(Long id){
        return repository.getBookRating(id);
    }

    public Optional<Book> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    public List<Book> getTop5() {
        return  repository.getTop5Book();
    }
}
