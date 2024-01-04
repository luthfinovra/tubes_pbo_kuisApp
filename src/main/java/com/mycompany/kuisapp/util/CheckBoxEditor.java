/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.util;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author LUTHFI NOVRA
 */
public class CheckBoxEditor extends AbstractCellEditor implements TableCellEditor {

    private final JCheckBox checkBox;

    public CheckBoxEditor(JCheckBox checkBox) {
        this.checkBox = checkBox;
        this.checkBox.setHorizontalAlignment(JCheckBox.CENTER);
        this.checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return checkBox.isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {

        if (value instanceof Boolean) {
            checkBox.setSelected((Boolean) value);
        }

        return checkBox;
    }
}