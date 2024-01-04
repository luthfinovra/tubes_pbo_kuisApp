/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizTableModel extends AbstractTableModel {

    private List<QuizRow> data;
    private Map<Integer, QuizRow> rowIndexToQuizRowMap;

    // ... (existing methods)
    @Override
    public int getColumnCount() {
        // Three columns: Checkbox column, question ID column, and question text column
        return 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // Checkbox column
        } else if (columnIndex == 1) {
            return Integer.class; // Question ID column
        } else {
            return String.class;  // Question text column
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        QuizRow row = data.get(rowIndex);
        if (columnIndex == 0) {
            return row.isSelected();
        } else if (columnIndex == 1) {
            return row.getQuestionId();
        } else {
            return row.getQuestionText();
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        // Get the quiz row object from the data list
        QuizRow quizRow = data.get(row);

        // Update the quiz row object based on the column index
        switch (col) {
            case 0: // Checkbox column
                quizRow.setSelected((Boolean) value);
                break;
            case 1: // Question id column
                quizRow.setQuestionId((Integer) value);
                break;
            case 2: // Question text column
                quizRow.setQuestionText((String) value);
                break;
        }

        // Notify the table that the data has changed
        fireTableCellUpdated(row, col);
    }

    public List<QuizRow> getData() {
        return data;
    }

    public void setData(List<QuizRow> data) {
        this.data = data;
        rowIndexToQuizRowMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            rowIndexToQuizRowMap.put(i, data.get(i));
        }
        fireTableDataChanged();
    }

    public int getRowCount() {
        return data.size();
    }

    public QuizRow getQuizRow(int rowIndex) {
        return rowIndexToQuizRowMap.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 0;
    }

}
