package View.Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForgotPassword2 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ForgotPassword2() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 300, 406);
		setLayout(null);
		

        JLabel lblNewLabel = new JLabel("Nhập mã OTP");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(137, 10, 225, 64);
        add(lblNewLabel);
        
	}

}
