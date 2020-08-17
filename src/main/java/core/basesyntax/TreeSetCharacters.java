package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> set = new TreeSet<Character>();
        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String string = scan.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
                for (char c : string.toCharArray()) {
                    set.add(c);
                }
            }
            StringBuilder result = new StringBuilder();
            for (char c : set) {
                result.append(c);
            }
            return result.toString().length() > 4
                    ? result.toString().substring(0, 5) : result.toString();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File [" + fileName + "] has not been found\n");
        }
    }
}
