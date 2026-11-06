package com.pronchenko.labs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class Main {

    // 26
    // TreeMap<String, Integer> — количество по полу, отсортировано по ключу
    // Считать в TreeMap, где ключ = gender, значение = количество персонажей.
    // Сохранить результат в файл в виде gender, count.

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path csvFile = Path.of(Objects.requireNonNull(Main.class.getResource("/characters.csv")).toURI());
        Path gendersFile = Path.of("gender.csv");

        FileService service = new FileService();
        Map<String, Integer> entitiesbygender = service.readEntitiesByGender(csvFile);

        service.writeEntitiesByGender(gendersFile, entitiesbygender);

        System.out.println("Task file were written to " + gendersFile.toAbsolutePath());
    }

}


