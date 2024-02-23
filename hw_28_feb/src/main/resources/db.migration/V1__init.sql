create table formats
(
    id     bigserial primary key,
    size   varchar(20),
    width  bigint,
    height bigint
);

create table categories
(
    id    bigserial primary key,
    title varchar(255)
);

create table authors
(
    id        bigserial primary key,
    full_name varchar(255)
);

create table books
(
    id        bigserial primary key,
    title     varchar(255),
    author_id bigint,
    genre     varchar(255),
    foreign key (author_id) references authors (id)

);

create table pages
(
    id             bigserial primary key,
    count          bigint,
    page_format_id bigint,
    book_id        bigint,
    foreign key (page_format_id) references formats (id),
    foreign key (book_id) references books (id)
);


create table comments
(
    id              bigserial primary key,
    name            varchar(255),
    text            text,
    rate            bigint,
    date            date,
    comment_book_id bigint,
    foreign key (comment_book_id) references books (id)
);

insert into categories (title)
values ('Категория 1'),
       ('Категория 2'),
       ('Категория 3');

insert into authors (full_name)
values ('Толкиен'),
       ('Роулинг'),
       ('Сандерсон'),
       ('Азимов'),
       ('Алексей Пехов'),
       ('Джордж Р. Р. Мартин');

insert into formats(size, width, height)
values ('small', 140, 200),
       ('middle', 170, 240),
       ('big', 200, 290);



insert into books (title, author_id, genre)
values ('Властелин колец: Братство кольца', 1, 'FANTASY'),
       ('Книга Гарри Поттера и узник Азкабана', 2, 'FANTASY'),
       ('Harry Potter and the Order of the Phoenix', 2, 'FANTASY'),
       ('Гарри Поттер и Философский Камень', 2, 'FANTASY'),
       ('Рожденный туманом. Книга 1. Пепел и сталь', 3, 'FANTASY'),
       ('Архив Буресвета: Путь королей', 3, 'FANTASY'),
       ('Академия', 4, 'SCIFI'),
       ('Летос', 5, 'FANTASY'),
       ('Игра престолов. Песнь льда и огня', 6, 'FANTASY');


insert into pages (count, page_format_id, book_id)
values (230, 3, 1),
       (460, 2, 1),
       (960, 1, 1);

insert into pages (count, page_format_id, book_id)
values (220, 3, 2),
       (450, 2, 2),
       (950, 1, 2);

insert into pages (count, page_format_id, book_id)
values (320, 3, 3),
       (650, 2, 3),
       (1300, 1, 3);

insert into pages (count, page_format_id, book_id)
values (182, 3, 4),
       (365, 2, 4),
       (730, 1, 4);

insert into pages (count, page_format_id, book_id)
values (440, 3, 5),
       (880, 2, 5),
       (1760, 1, 5);

insert into pages (count, page_format_id, book_id)
values (575, 3, 6),
       (1152, 2, 6),
       (2310, 1, 6);

insert into pages (count, page_format_id, book_id)
values (160, 3, 7),
       (320, 2, 7),
       (640, 1, 7);

insert into pages (count, page_format_id, book_id)
values (186, 3, 8),
       (376, 2, 8),
       (732, 1, 8);

insert into pages (count, page_format_id, book_id)
values (384, 3, 9),
       (768, 2, 9),
       (1450, 1, 9);


insert into comments (name, text, rate, date, comment_book_id)
values ('Sergey', '"The Lord of the Ring: The fellowship of the Ring" is very fine book', 10, '2024-02-16', 1),
       ('Olga', 'I spent wodenfull time reading this book, but it was much long', 9, '2024-02-28', 1);

insert into comments (name, text, rate, date, comment_book_id)
values ('Martin', '"The Book of Harry Potter and the Prisoner of Azkaban" is a real gift for fantasy lovers', 10,
        '2024-01-26', 2),
       ('Valentina', 'The book is not to my taste. Written a little darkly for me', 8, '2024-02-10', 2);

insert into comments (name, text, rate, date, comment_book_id)
values ('Semen',
        '"Harry Potter and the Order of the Phoenix" is loaded with a lot of different themes probably because it is also the longest Harry Potter book ever written. It contains almost all the themes from previous books and also more that make it a very large body of literature to analyze.',
        9, '2024-02-12', 3),
       ('Oksana',
        'I absolutely adore the fifth book in the Harry Potter series. The pages of this book are ignited by adventure and magic. It''s a book I would recommend to all ages, but mostly to children.',
        10, '2024-01-20', 3),
       ('Fedor', 'Order of the Phoenix was the longest Harry Potter book, therefore a lot was cut in film represent.',
        7, '2024-02-25', 3);

insert into comments (name, text, rate, date, comment_book_id)
values ('Anton', 'I''ve probably read this 100 times but I never get tired of it!', 9, '2024-02-24', 4),
       ('Oksana', 'I''ve read it so many times, in my opinion, this deserves a good review with the news.', 9,
        '2024-02-20', 4),
       ('Boris', 'The Harry Potter series rule! It''s soo interesting, mysterious, and fun!', 8, '2024-02-19', 4);

insert into comments (name, text, rate, date, comment_book_id)
values ('Alex',
        'I just finished reading this way in the early morning and absolutely loved it. Let me say that I totally didn''t expect to shed tears at 4am ',
        9, '2024-01-25', 5),
       ('Sveta', 'I think both the second book of Mistborn and Stormlight Archive are even better, so have fun!', 6,
        '2024-02-23', 5),
       ('Kiril',
        'In that book shows fascinating characters I’ve encountered in a fantasy novel, so he’d be my first choice. I’d want to know more about his people’s history and how his ability to store up powers works.',
        5, '2024-02-17', 5);

insert into comments (name, text, rate, date, comment_book_id)
values ('Artem',
        'Basically. It is a slower book. Their setting up for a 9(I think) book series. BrandoSando Paints a better world than others, but if your not used to it, I could see it being dry',
        7, '2024-02-25', 6),
       ('Sofa',
        'A great book that sets the stage for what possibly could be one of the greatest fantasy series of all time, up there with Lord of the Rings.',
        10, '2024-01-23', 6),
       ('Kostya',
        'A Positively amazing book, that promises to be one of the best fantasy series ever written. Sanderson has once again amazed us with his skill and imagination. I can''t wait for the rest of the series. It may be long but I recommend it for any fan of fantasy, just read it.',
        6, '2024-02-07', 6),
       ('Luba',
        'Greatest high fantasy book I have ever read. Sanderson is so unique in his style, and really makes the adrenaline run during action scenes. He still is the master of that.',
        9, '2024-02-24', 6),
       ('Polina',
        'Great characters, interesting mystery and mythology, fascinating cultures and magic system (which we only partially see). It''s long, but well paced, and instantly re-readable. It could even rival George R.R. Martin''s "A Song of Ice and Fire" for my favorite series if it lives up to its full potential.',
        9, '2024-0-29', 6);

insert into comments (name, text, rate, date, comment_book_id)
values ('Leonid',
        ' I finished reading the "Academy" and am somewhat perplexed. And this is considered a landmark, landmark novel for the development of science fiction and for Asimov in particular?',
        7, '2023-05-21', 7),
       ('Antonina',
        '"Academy" is something fundamental and sophisticated at the same time. Something that allows you to see the scope of the writer’s thoughts and enjoy a truly colossal saga, whose events unfold simultaneously on dozens of planets. The universe is literally seething, and you just watch what ideas the characters generate and what they try to translate into reality. And what obstacles are put in front of them by the forces of the existing empire, which is firmly convinced of the falsity of the new science.',
        10, '2024-02-28', 7),
       ('Masha',
        ' I became acquainted with the work of this writer not so long ago, already in adulthood. I watch the lectures of the scientist-historian Andrei Fursov on the Internet, and he quite often mentions this book, “Academy,” in his lectures for students (well, I study with them).I became interested... found out that this work is taught to the American military, it turns out that this book is very important.',
        6, '2024-02-21', 7),
       ('Kristina',
        'I often hear that early Asimov is too difficult to understand. That is why I was very upset when this book dropped out in the game.Well what can I say? I liked the beginning. Scientist Gary Seldon mathematically predicts the collapse of the Empire. Therefore, it is necessary to create an Encyclopedia in which it will be possible to save literally everything. And then it became clear that what would be interesting for me personally in this book would only be the bones of the plot. Events are developing too quickly, the story jumps, the characters are somehow characterless and faceless. They just exist, do something and talk about something. And, besides, they are mostly male. Either I’m blind and deaf, or there really were almost no women.',
        7, '2024-02-11', 7);



insert into comments (name, text, rate, date, comment_book_id)
values ('Антонина',
        'Очень понравилась эта книга! Первая часть цикла из 5 книг (последняя вышла в этом году совсем недавно!) Эта история захватила меня и я сразу же после прочтения первой части заказала вторую! Читаешь и не оторваться. Как всегда в восторге от автора и его сюжетных поворотов. Рекомендую к прочтению!',
        9, '2024-05-23', 8),
       ('Оксана',
        'Всё просто - это один из уникальных миров Пехова! Книга захватывает и уже не отпускает, а после прочтения начинается "ломка" - сложно начать читать какие-то другие книги! Хочется снова и снова встретиться с героями, пройти их путь заново или пуститься с ними в новое путешествие, но не расставаться. Не успела приобрести бумажный вариант книг, теперь довольствуюсь электронными - жаааль. Наверное сразу скупать новинки буду Подробнее: https://www.labirint.ru/reviews/goods/453313/',
        10, '2024-02-28', 8),
       ('Зинаида',
        'Лет несколько назад пыталась читать книга Пехова, но не пошло на 2-й главе стало невыносимо скучно, бросила. Не знаю почему решила купить эту трилогию (этим летом очень тянуло читать, а ещё была скидка) что-то пошло не так и читать я начала с конца, с Талориса. Но меня захватило, очень понравились отсылки к старым эпохам! Прочитала с великим удовольствием! Надеюсь на продолжение! ',
        6, '2024-02-17', 8),
       ('Света',
        'А мне книга (все три части, пока три) понравилась. В стиле автора: читается легко, интересно, с юмором. Однозначно жду продолжения)',
        6, '2024-02-27', 8),
       ('Алиса',
        'конечно продолжение куплю, но восторга от книги не испытываю и если продолжение не выйдет, то не расстроюсь, так же как и не жду его выхода с нетерпением. Действительно, такое чувство как будто разных героев из разных циклов запихнули в эту книгу и смотрят что из этой мешанины получится. Я не сравниваю Пехова с другими авторами, а только с его предыдущими книгами. И поэтому я собираюсь перечитать Стража...в третий раз.',
        5, '2024-02-17', 8);

insert into comments (name, text, rate, date, comment_book_id)
values ('Сергей', '"Автор болен, потому, что это написал. Я больна, потому что мне это понравилось.', 9, '2024-02-16', 9),
       ('Olga', 'Очень интересное произведение, но растянуто немного слишком сильно.', 7, '2024-02-18', 9),
       ('Федор', '"В принципе очень даже ничего ))', 8, '2024-02-06', 9),
       ('Константин', 'Джордж Мартин - гений!', 7, '2024-02-18', 9)

