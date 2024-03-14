package ru.otus.hw_28_feb.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw_28_feb.dtos.*;
import ru.otus.hw_28_feb.entities.Book;
import ru.otus.hw_28_feb.repositories.BookRepository;
import ru.otus.hw_28_feb.services.PageService;

import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/books/")
public class BookDtoController {
    private final PageService service;
    List<CommentBookDto> comments;
    private final BookRepository bookRepository;

    private static final Function<Book, BookDto> MAP_TO_DTO_FUNCTION = cb -> new BookDto(cb.getId(), cb.getTitle());

    public BookDtoController(PageService service, BookRepository bookRepository) {
        this.service = service;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public List<PageDto> getBooks(@PathVariable int pageNumber, @PathVariable int pageSize) {
        List<PageDtoPagination> pages = service.pageDtoPaginationByFormat(pageSize);
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(0, pages.size()));
        List<PageDto> dtos = new ArrayList<>();
        for (int i = 0; i <= pages.size() - 1; i++) {
            dtos.add(new PageDto(bookPage.getContent(),
                    pageNumber,
                    pages.get(i).getSize(),
                    bookPage.getContent().get(i).getTitle(),
                    pages.get(i).getCount(),
                    bookPage.getContent().size()));
        }
        return dtos;
    }

    @GetMapping(value = "{id}/rating")
    public CommentBookDto getRating(@PathVariable Long id) {
        comments = service.getBookRating(id);
        double average = comments.stream().map(CommentBookDto::getRate).
                reduce(0.0, (subtotal, element) -> subtotal/comments.size() + element/comments.size());
        return new CommentBookDto(id, comments.get(0).getTitle(), average);
    }

    @GetMapping(value = "top5")
    public List<BookDto> getTopBooks() {
        return service.getTop5().stream().map(MAP_TO_DTO_FUNCTION).toList();
    }
}

