package com.vue;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
class JTableRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		this.setHorizontalAlignment(JLabel.CENTER);
	return this;
}
}