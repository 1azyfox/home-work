package com.sbrf.reboot.collections;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество баллов, чтобы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов, чтобы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {

        List<String> students = new LinkedList<>();

        students.add("Сидоров");
        students.add("Петров");
        students.add("Иванов");
        students.add("Козлов");

        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет, чтобы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = new HashSet<>();

        moneyBox.add(1);
        moneyBox.add(2);
        moneyBox.add(10);
        moneyBox.add(50);
        moneyBox.add(100);
        moneyBox.add(200);
        moneyBox.add(500);
        moneyBox.add(1000);
        moneyBox.add(2000);
        moneyBox.add(5000);

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги, чтобы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        @AllArgsConstructor
        class Book {
            String author;
            String name;
        }

        List<Book> bookshelf = new ArrayList<>();

        Book tolstoyWarAndPeace = new Book("tolstoy","warAndPeace");
        Book chekhovWardNo6 = new Book("chekhov","wardNo6");
        Book dostoevskyCrimeAndPunishment = new Book("dostoevsky","crimeAndPunishment");

        bookshelf.add(tolstoyWarAndPeace);
        bookshelf.add(chekhovWardNo6);
        bookshelf.add(dostoevskyCrimeAndPunishment);

        assertEquals(3, bookshelf.size());
    }


}
