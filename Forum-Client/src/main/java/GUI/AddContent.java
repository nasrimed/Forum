package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.hibernate.tuple.GenerationTiming;

import com.toedter.calendar.JYearChooser;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import Entities.Category;
import Entities.Content;
import Entities.Genre;
import businessDelegate.ContentServicesDelegate;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.util.Locale;

public class AddContent extends JFrame {

	private JFrame frame;
	private JTextField titlelb;
	private JTextField trailerlb;
	JComboBox comboBoxCat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContent window = new AddContent();
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
	public AddContent() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 373, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(31, 48, 30, 22);
		frame.getContentPane().add(lblTitle);
		
		titlelb = new JTextField();
		titlelb.setBounds(103, 49, 86, 20);
		frame.getContentPane().add(titlelb);
		titlelb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Genre");
		lblNewLabel.setBounds(30, 81, 36, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setBounds(103, 80, 86, 22);
		comboBoxGenre.setModel(new DefaultComboBoxModel(Genre.values()));
		frame.getContentPane().add(comboBoxGenre);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(31, 126, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea descriptionlb = new JTextArea();
		descriptionlb.setBounds(101, 121, 165, 56);
		frame.getContentPane().add(descriptionlb);
		
		JLabel lblTrailer = new JLabel("Trailer");
		lblTrailer.setBounds(31, 192, 46, 14);
		frame.getContentPane().add(lblTrailer);
		
		trailerlb = new JTextField();
		trailerlb.setBounds(103, 189, 163, 20);
		frame.getContentPane().add(trailerlb);
		trailerlb.setColumns(10);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(113, 220, 46, 20);
		frame.getContentPane().add(yearChooser);
		
		JLabel lblReleaseYear = new JLabel("Release Year");
		lblReleaseYear.setBounds(30, 226, 63, 14);
		frame.getContentPane().add(lblReleaseYear);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(31, 271, 46, 14);
		frame.getContentPane().add(lblRating);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(103, 268, 56, 20);
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 10.0, 1.0));
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(31, 308, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(236, 249, 89, 59);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String title = titlelb.getText();
				Genre genre = (Genre) comboBoxGenre.getSelectedItem();
				//content.setGenre(genre);
				String description=descriptionlb.getText();
				String trailer= trailerlb.getText();
				int yearReleased=yearChooser.getComponentCount();
			   Double rating= (Double) spinner.getValue();
			  Category category = (Category) comboBoxCat.getSelectedItem();
			   
			   
			 
			  
			   
			    
				//content.setCategory(category);
				
				ContentServicesDelegate.addContent(title,genre,description,trailer,yearReleased,rating,category);
				
				
				//JComboBox<Mood> comboBox = new JComboBox<>();
				//comboBox.setModel(new DefaultComboBoxModel<>(Mood.values()));
			}
		});
		frame.getContentPane().add(btnAdd);
		
	comboBoxCat = new JComboBox();
	comboBoxCat.setBounds(103, 299, 86, 20);
		comboBoxCat.setModel(new DefaultComboBoxModel(Category.values()));
		frame.getContentPane().add(comboBoxCat);
		
		
		
		
	}
}
