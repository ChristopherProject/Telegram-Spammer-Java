import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import UI.RequestUtils;

public class Avvio {

	private JFrame frame;
	private JTextField DelayValue;
	private JTextField ChatIDValue;
	private JTextField BotAPIValue;
	boolean canspam = false;
	private JTextField QuantityValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avvio window = new Avvio();
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
	public Avvio() {
	   initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("TelegramSpammer-v0.2");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Copyright = new JLabel("Telegram Spammer By Russian412");
		Copyright.setForeground(Color.RED);
		Copyright.setBounds(10, 0, 203, 31);
		frame.getContentPane().add(Copyright);
	
		JLabel DelayText = new JLabel("Delay");
		DelayText.setForeground(Color.WHITE);
		DelayText.setBounds(10, 29, 57, 23);
		frame.getContentPane().add(DelayText);
		
		 DelayValue = new JTextField(3);
		DelayValue.setBounds(50, 30, 86, 20);
		frame.getContentPane().add(DelayValue);
		DelayValue.setColumns(3);
		
		JLabel ChatIDText = new JLabel("ChatID");
		ChatIDText.setForeground(Color.WHITE);
		ChatIDText.setBounds(10, 61, 126, 42);
		frame.getContentPane().add(ChatIDText);
		
		ChatIDValue = new JTextField();
		ChatIDValue.setBounds(50, 72, 86, 20);
		frame.getContentPane().add(ChatIDValue);
		
		BotAPIValue = new JTextField();
		BotAPIValue.setBounds(196, 47, 217, 20);
		frame.getContentPane().add(BotAPIValue);
		
		JLabel BotText = new JLabel("Your Bot Token");
		BotText.setForeground(Color.WHITE);
		BotText.setBounds(259, 29, 86, 14);
		frame.getContentPane().add(BotText);
		
		JLabel QuantityText = new JLabel("Quantity");
		QuantityText.setForeground(Color.WHITE);
		QuantityText.setBounds(273, 80, 58, 23);
		frame.getContentPane().add(QuantityText);
		
		QuantityValue = new JTextField(3);
		QuantityValue.setBounds(327, 83, 86, 20);
		frame.getContentPane().add(QuantityValue);
		
		JLabel MessageText = new JLabel("Message HERE:");
		MessageText.setForeground(Color.WHITE);
		MessageText.setBounds(10, 103, 126, 42);
		frame.getContentPane().add(MessageText);
		
		JTextArea MessageValue = new JTextArea();
		MessageValue.setBounds(37, 137, 376, 86);
		frame.getContentPane().add(MessageValue);
		
		JButton Start = new JButton("Start");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked Start");
				canspam = true;
				
				String API = BotAPIValue.getText();
				String aspetta = DelayValue.getText();
				String targetchat = ChatIDValue.getText();
				String messaggio = MessageValue.getText();
				String quantity = QuantityValue.getText();
			
				
				for(int i = 0; i < Integer.parseInt(quantity); i++) {
					System.out.println("Duck");
					try {
						Aspetta(Integer.parseInt(aspetta));
						RequestUtils.httpRequest(new URL("https://api.telegram.org/bot" + API + "/sendMessage?chat_id=" + targetchat + "&text=" + URLEncoder.encode(messaggio, "UTF-8") + "&parse_mode=HTML&disable_web_page_preview=true"));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		Start.setBounds(256, 234, 89, 23);
		frame.getContentPane().add(Start);
		
		JButton Stop = new JButton("Stop");
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked Stop");
				canspam = false;
			}
		});
		Stop.setBounds(112, 234, 89, 23);
		frame.getContentPane().add(Stop);
	}
	
	static void Aspetta(int sec) {
		try {
			Thread.sleep(1000* sec);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
