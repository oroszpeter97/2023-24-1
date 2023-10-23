package src;

import java.util.ArrayList;
import java.util.List;


public class JoinExample {
    public static List<String> innerJoin(Table table1, Table table2) {
        List<String> result = new ArrayList<>();
        for (String row1 : table1.getData()) {
            String[] parts1 = row1.split(", ");
            String id1 = parts1[2]; // Third ID in table1
            for (String row2 : table2.getData()) {
                String[] parts2 = row2.split(", ");
                String id2 = parts2[0]; // ID in table2
                if (id1.equals(id2)) {
                    result.add(row1 + ", " + row2);
                }
            }
        }
        return result;
    }

    public static List<String> outerJoin(Table table1, Table table2) {
        List<String> result = new ArrayList<>();
        for (String row1 : table1.getData()) {
            boolean matched = false;
            String[] parts1 = row1.split(", ");
            String id1 = parts1[2]; // Third ID in table1
            for (String row2 : table2.getData()) {
                String[] parts2 = row2.split(", ");
                String id2 = parts2[0]; // ID in table2
                if (id1.equals(id2)) {
                    result.add(row1 + ", " + row2);
                    matched = true;
                }
            }
            if (!matched) {
                result.add(row1 + ", null");
            }
        }
        for (String row2 : table2.getData()) {
            boolean matched = false;
            String[] parts2 = row2.split(", ");
            String id2 = parts2[0]; // ID in table2
            for (String row1 : table1.getData()) {
                String[] parts1 = row1.split(", ");
                String id1 = parts1[2]; // Third ID in table1
                if (id1.equals(id2)) {
                    matched = true;
                }
            }
            if (!matched) {
                result.add("null, " + row2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Table table1 = new Table();
        table1.addRow("1, Alice, 100");
        table1.addRow("2, Bob, 101");
        table1.addRow("3, Carol, 102");

        Table table2 = new Table();
        table2.addRow("100, Engineer");
        table2.addRow("101, Doctor");
        table2.addRow("103, Artist");

        List<String> innerJoinResult = innerJoin(table1, table2);
        System.out.println("Inner Join Result:");
        for (String row : innerJoinResult) {
            System.out.println(row);
        }

        List<String> outerJoinResult = outerJoin(table1, table2);
        System.out.println("Outer Join Result:");
        for (String row : outerJoinResult) {
            System.out.println(row);
        }
    }
}