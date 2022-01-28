package helper;


import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Helper {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void writeToCSV(String allstorename) throws IOException {
        String csv = "allstorenames.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(new String[]{allstorename});
        writer.close();
    }
    public static void readToCSV() throws IOException, CsvException {
        String csv = "allstorenames.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        System.out.println("Second store is '"+lines.get(50529)+"' to start to s in AllStorenames.csv");
        }


    }



