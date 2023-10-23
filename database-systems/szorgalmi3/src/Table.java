package src;
import java.util.ArrayList;
import java.util.List;

class Table {
    private List<String> data;

    public Table() {
        data = new ArrayList<>();
    }

    public void addRow(String row) {
        data.add(row);
    }

    public List<String> getData() {
        return data;
    }
}