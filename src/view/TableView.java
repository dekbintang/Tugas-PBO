package src.view;

import java.util.ArrayList;
import java.util.List;

public class TableView {
    private List<String> headers;
    private List<List<String>> rows;
    private List<Integer> columnWidths;
    private int tableWidth;
    private String horizontalLine;

    public TableView() {
        this.headers = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.columnWidths = new ArrayList<>();
    }

    public void setHeaders(String... headerLabels) {
        headers.clear();
        columnWidths.clear();

        for (String header : headerLabels) {
            headers.add(header);
            columnWidths.add(header.length());
        }

        calculateTableDimensions();
    }

    public void addRow(String... cells) {
        if (cells.length != headers.size()) {
            throw new IllegalArgumentException("Jumlah kolom tidak sesuai dengan header");
        }

        List<String> row = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            row.add(cells[i]);
            columnWidths.set(i, Math.max(columnWidths.get(i), cells[i].length()));
        }

        rows.add(row);
        calculateTableDimensions();
    }

    public void clearRows() {
        rows.clear();
    }

    private void calculateTableDimensions() {
        tableWidth = 1; // Awal karakter '|'
        for (int width : columnWidths) {
            tableWidth += width + 3; // width + 2 (spasi) + 1 (|)
        }

        horizontalLine = "+" + "-".repeat(tableWidth - 2) + "+";
    }

    public void render() {
        if (headers.isEmpty()) {
            return;
        }

        System.out.println(horizontalLine);

        // Render headers
        System.out.print("| ");
        for (int i = 0; i < headers.size(); i++) {
            System.out.print(padRight(headers.get(i), columnWidths.get(i)) + " | ");
        }
        System.out.println();

        System.out.println(horizontalLine);

        // Render data rows
        for (List<String> row : rows) {
            System.out.print("| ");
            for (int i = 0; i < row.size(); i++) {
                System.out.print(padRight(row.get(i), columnWidths.get(i)) + " | ");
            }
            System.out.println();
        }

        System.out.println(horizontalLine);
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}