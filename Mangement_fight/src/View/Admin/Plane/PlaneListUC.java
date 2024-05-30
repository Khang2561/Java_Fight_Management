package View.Admin.Plane;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.Admin.Admin_header;
import View.Admin.FormAdmin;
import libData.JDBCUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class PlaneListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	static Connection c = JDBCUtil.getConnection();
	public PlaneListUC() {
		setLayout(null);
		setBounds(0, 0, 1365, 520);
		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã máy bay", "Tên máy bay", "Số lượng ghế"
			}
		));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//load db
		
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * from PLANE";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			while(rs.next()) {
				model.addRow(new Object[] { rs.getString("PlaneID"), rs.getString("PlaneName"), rs.getString("SeatCount")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

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
		
		JPanel panel = new JPanel();
		panel.setBounds(1116, 45, 249, 25);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 30, 0));
		
		JButton btnThongTin = new JButton("Điều chỉnh");
		btnThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnThongTin);
		btnThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OperationPlaneUC ope = new OperationPlaneUC(getSelectRow(table.getSelectedRow()));
				clearAndShow(ope);

				
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnXoa);
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String sql = "DELETE FROM PLANE WHERE PlaneID = ?";
				PreparedStatement pstmt;
				try {
					pstmt = c.prepareStatement(sql);
                    pstmt.setString(1, table.getValueAt(selectedRow, 0).toString());
                    pstmt.executeUpdate();
                    showAndReloadTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


	}
	public void showAndReloadTable() {
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * from PLANE";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int rowCount = model.getRowCount();
			if(rowCount>0) {
				for (int i = rowCount - 1; i >= 0; i--) {
					  model.removeRow(i);
					}
			}			
			while(rs.next()) {
				model.addRow(new Object[] { rs.getString("PlaneID"), rs.getString("PlaneName"), rs.getString("SeatCount")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public int getSelectRow(int row) {
		
		return row;
	}
	public static void clearAndShow(JPanel newPanel) {
        PlaneUC.contentPanel.removeAll(); // Remove all components from contentPane
        PlaneUC.contentPanel.add(newPanel); // Add the new panel to contentPane
        newPanel.setSize(1365, 520);
        newPanel.setLocation(0, 0);
        PlaneUC.contentPanel.revalidate(); // Refresh the contentPane
        PlaneUC.contentPanel.repaint(); // Repaint the contentPane
    }
}
