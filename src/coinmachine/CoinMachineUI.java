package coinmachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class CoinMachineUI {

	private JFrame frame;
	private CoinMachine CoinInsert ;
	private Coin oneBath ;
	private Coin fiveBath ;
	private Coin tenBath ;
	private Demo runDemo ;
	private JButton button ;
	private JButton button_1 ;
	private JButton button_2 ;
	private JProgressBar progressBar ;
	private int numCoin ;
	private int sumBalance ;
	private JLabel lblNewLabel_2 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinMachineUI window = new CoinMachineUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoinMachineUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(19, 18, 133, 47);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Status :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel_1.setBounds(199, 29, 110, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		button = new JButton("");
		button.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/1baht.png")));
		button.setBounds(22, 99, 94, 96);
		frame.getContentPane().add(button);
		addCoin(button);
		
		
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/5baht.png")));
		button_1.setBounds(173, 99, 94, 96);
		frame.getContentPane().add(button_1);
		addCoin(button_1);
		
		
		button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/10baht.png")));
		button_2.setBounds(342, 87, 100, 105);
		frame.getContentPane().add(button_2);
		addCoin(button_2);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(139, 18, 42, 47);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(292, 29, 165, 25);
		frame.getContentPane().add(progressBar);
		progressBar.setMaximum(10);
		

	}
	public void addCoin(JButton b1){
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CoinInsert = new CoinMachine(10);
				runDemo = new Demo();
				oneBath = new Coin(1);
				fiveBath = new Coin(5);
				tenBath = new Coin(6);
				
				if(b1 == button){
					if(numCoin < 10){
					CoinInsert.insert(oneBath);
					numCoin += CoinInsert.getCount();
					sumBalance += CoinInsert.getBalance();
					progressBar.setValue(numCoin);
					lblNewLabel_2.setText(""+sumBalance);
					
					}
					
				}else if(b1 == button_1){
					if(numCoin < 10){
					CoinInsert.insert(fiveBath);
					numCoin += CoinInsert.getCount();
					sumBalance += CoinInsert.getBalance();
					progressBar.setValue(numCoin);
					lblNewLabel_2.setText(""+sumBalance);
					}
				}else if(b1 == button_2){
					if(numCoin < 10){
					CoinInsert.insert(tenBath);
					numCoin += CoinInsert.getCount();
					sumBalance += CoinInsert.getBalance();
					progressBar.setValue(numCoin);
					lblNewLabel_2.setText(""+sumBalance);
					}
					
				}
				
			}
			
		});
	}
}

