package com.nminh.thuctapdulich.repository.impl;

import org.springframework.stereotype.Repository;

import java.io.*;
@Repository
public class ID_Manage {
    private static final String FILE_ID = "lastId.txt";
    public static Long getLastId() {
        File file = new File(FILE_ID);
        if(!file.exists()) {
            return 0L;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            Long id = Long.parseLong(br.readLine());
            return id;
        }catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
    public static void saveLastId(Long id) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ID))) {
            bw.write(String.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
