package View.Admin.Plane;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PlaneListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	public PlaneListUC() {
		setLayout(null);
		setBounds(0, 0, 1365, 520);
		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã máy bay", "Tên máy bay", "Số lượng ghế", "Thao tác"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(83);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 80, 1365, 430);
		add(scrollPane);

		textField = new JTextField();
		textField.setToolTipText("Mã máy bay hoặc tên máy bay");
		textField.setBounds(0, 45, 249, 25);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nhập mã máy bay hoặc tên máy bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 10, 260, 25);
		add(lblNewLabel);



	}
}
