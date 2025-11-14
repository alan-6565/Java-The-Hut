package com.javahut.order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;          // List, ArrayList, Collections
import java.time.*;          // LocalDateTime
import java.time.format.*;   // DateTimeFormatter

public class Order {

    private final List<LineItem> items = new ArrayList<>();
    private final LocalDateTime createdAt = LocalDateTime.now();

    public void add(LineItem item) {
        items.add(0, item);
    }

    public List<LineItem> items() {
        return Collections.unmodifiableList(items);
    }

    public double total() {
        double sum = 0.0;
        for (LineItem lineItem : items) {
            sum += lineItem.price();
        }
        return sum;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public String renderReciept() {
        String reciept = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        reciept += "Java the Hut\n";
        reciept += "Date: " + fmt.format(createdAt) + "\n";
        reciept += "============================================\n";

        for (LineItem lineItem : items) {
            reciept += String.format("%-40s $%6.2f%n", lineItem.describe(), lineItem.price());
        }

        reciept += "============================================\n";
        reciept += String.format("TOTAL: $%.2f%n", total());

        return reciept;
    }


    public void saveReciept() {
        String reciept = renderReciept();

        try {
            Path folder = Path.of("receipts");
            Files.createDirectories(folder);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipt_" + fmt.format(createdAt) + ".txt";
            Path file = folder.resolve(fileName);

            Files.writeString(file, reciept);
            System.out.println("Receipt was saved to: " + file.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("COULD NOT SAVE RECEIPT" + e.getMessage());
        }
    }
}
