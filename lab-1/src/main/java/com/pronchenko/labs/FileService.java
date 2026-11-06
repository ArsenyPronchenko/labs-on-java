package com.pronchenko.labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class FileService {

    // чтение и сразу запись в treemap
    public Map<String, Integer> readEntitiesByGender(Path csvFile) throws IOException {
        Map<String, Integer> entitiesbygender = new TreeMap<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFile, StandardCharsets.UTF_8)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                Entity entity = new Entity(
                        Integer.parseInt(columns[0]),
                        columns[1],
                        columns[2],
                        columns[3],
                        columns[4],
                        columns[5],
                        columns[6],
                        columns[7],
                        columns[8]
                );
                if (entitiesbygender.containsKey(entity.getGender())){
                    entitiesbygender.put(entity.getGender(), entitiesbygender.get(entity.getGender()) + 1);
                } else {
                    entitiesbygender.put(entity.getGender(), 1);
                }
            }
        }

        return entitiesbygender;
    }

    // запись treemap в csv
    public void writeEntitiesByGender(Path csvFile,  Map<String, Integer> entitiesbygender) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(csvFile, StandardCharsets.UTF_8)) {
            writer.write("gender" + "," + "count");
            writer.newLine();
            // map.entry множества пар ключ значение по нашей treemap
            for (Map.Entry<String, Integer> entry : entitiesbygender.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        }
    }
    
    // методы для доп задания
    public List<Entity> readEntities(Path csvFile) throws IOException {
        List<Entity> entities = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFile, StandardCharsets.UTF_8)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                entities.add(new Entity(
                        Integer.parseInt(columns[0]),
                        columns[1],
                        columns[2],
                        columns[3],
                        columns[4],
                        columns[5],
                        columns[6],
                        columns[7],
                        columns[8]
                ));
            }
        }

        return entities;
    }

    public void createEntities(Path csvFile, List<Entity> entities) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(csvFile, StandardCharsets.UTF_8)) {
            writer.write("id" + "," + "name" + "," + "status" + "," + "species" + "," + "type" + "," + "gender" + "," + "origin" + "," + "location" + "," + "created");
            writer.newLine();
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                writer.write(entity.getId() + "," + entity.getName() + "," + entity.getStatus() + "," + entity.getSpecies() + "," + entity.getType() + "," + entity.getGender() + "," + entity.getOrigin() + "," + entity.getLocation() + "," + entity.getCreated());
                writer.newLine();
            }
        }
    }

    public void appendEntities(Path csvFile, List<Entity> appendentities) throws IOException {
        List<Entity> entities = readEntities(csvFile);
        entities.addAll(appendentities);
        try (BufferedWriter writer = Files.newBufferedWriter(csvFile, StandardCharsets.UTF_8)) {
            writer.write("id" + "," + "name" + "," + "status" + "," + "species" + "," + "type" + "," + "gender" + "," + "origin" + "," + "location" + "," + "created");
            writer.newLine();
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                writer.write(entity.getId() + "," + entity.getName() + "," + entity.getStatus() + "," + entity.getSpecies() + "," + entity.getType() + "," + entity.getGender() + "," + entity.getOrigin() + "," + entity.getLocation() + "," + entity.getCreated());
                writer.newLine();
            }
        }
    }

    public void deleteEntities(Path csvFile, List<Entity> deleteentities) throws IOException {
        List<Entity> entities = readEntities(csvFile);
        entities.removeAll(deleteentities);
        try (BufferedWriter writer = Files.newBufferedWriter(csvFile, StandardCharsets.UTF_8)) {
            writer.write("id" + "," + "name" + "," + "status" + "," + "species" + "," + "type" + "," + "gender" + "," + "origin" + "," + "location" + "," + "created");
            writer.newLine();
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                writer.write(entity.getId() + "," + entity.getName() + "," + entity.getStatus() + "," + entity.getSpecies() + "," + entity.getType() + "," + entity.getGender() + "," + entity.getOrigin() + "," + entity.getLocation() + "," + entity.getCreated());
                writer.newLine();
            }
        }
    }

}
