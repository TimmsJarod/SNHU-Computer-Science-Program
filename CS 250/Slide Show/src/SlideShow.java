import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	/**
	 * Images replaced in resource folder and get methods changed to receive new photos.
	 * Added variables that hold image credits and sources, then adds them under the photo in the program.
	 * Made credit text more discrete.
	 */
	private String getResizeIcon(int i) {
		String image = "";
		String dest1 = "<br><font size = '1'>Photo: Osseous, https://commons.wikimedia.org/wiki/File:Enjoying_the_Beach_at_Lauderdale-by-the-Sea_Florida_02.jpg</font>";
		String dest2 = "<br><font size = '1'>Photo: Laya Gerlock, https://commons.wikimedia.org/wiki/File:4_Italian_Girls_in_Hawaii_beach.jpg</font>";
		String dest3 = "<br><font size = '1'>Photo: Yellow Stone National Park, https://commons.wikimedia.org/wiki/File:Hikers_along_the_Yellowstone_River_near_Garnett_Hill_(30798471023).jpg</font>";
		String dest4 = "<br><font size = '1'>Photo: Schi11, https://commons.wikimedia.org/wiki/File:A_boy_on_a_hiking_break_in_the_Dolomites.jpg</font>";
		String dest5 = "<br><font size = '1'>Photo: Rikku411, https://commons.wikimedia.org/wiki/File:Meditation_at_Empty_Cloud.jpg</font>";
		if (i==1){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/Florida.jpg") + "'" + dest1 + "</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/Hawaii.jpg") + "'" + dest2 + "</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/YellowStone.jpg") + "'" + dest3 + "</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/Dolomites.jpg") + "'" + dest4 + "</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/NewJersey.jpg") + "'" + dest5 + "</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	/**
	 * Text changed and filled out to labels and describe top detox/wellness location.
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Florida Coast.</font> <br>Warm beach fronts popular for swimming and decompressing.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Hawaii.</font> <br>Tropical sands and waters. Great location for surfboarding.</body></html>\"";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Yellow Stone National Park.</font> <br>Geyser riddled nature park with hiking trails and sightseeing destinations.</body></html>\"";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 The Dolomites, Italy.</font> <br>Pale mountains in Northeastern Italy popular with hikers.</body></html>\"";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Empty Cloud Monastery, New Jersey.</font> <br>Quiet getaway for yoga and meditation classes.</body></html>\"";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}