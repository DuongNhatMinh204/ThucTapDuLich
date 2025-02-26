package com.nminh.thuctapdulich.repository.impl;

import org.springframework.stereotype.Repository;

import java.io.*;
@Repository
public class ID_Manage {
    private static final String FILE_ID_USER = "lastId.txt";
    private static final String FILE_ID_BOOK = "lastIdBook.txt";
    private static final String FILE_ID_FILGHT = "lastIdFilght.txt";
    // ----USER----
    public static Long getLastIdUser() {
        File file = new File(FILE_ID_USER);
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
    public static void saveLastIdUser(Long id) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ID_USER))) {
            bw.write(String.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ----BOOK-----
    public static Long getLastIdBoook() {
        File file = new File(FILE_ID_BOOK);
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
    public static void saveLastIdBook(Long id) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ID_BOOK))) {
            bw.write(String.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // -------FLIGHT-------
    public static Long getLastIdFlight() {
        File file = new File(FILE_ID_FILGHT);
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
    public static void saveLastIdFlight(Long id) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ID_FILGHT))) {
            bw.write(String.valueOf(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
