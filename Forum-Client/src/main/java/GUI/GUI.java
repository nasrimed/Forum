package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Entities.Content;
import Services.ContentServicesRemote;
import businessDelegate.ContentServicesDelegate;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import com.toedter.calendar.JYearChooser;
import javax.swing.DefaultComboBoxModel;
import Entities.Genre;
import Entities.Category;

public class GUI extends JFrame {

	private JFrame frame;
	private JTable table;
	List<Content>contents;
	private JTextField titlelb;
	private JTextField trailerlb;
	private JTextField descriptionlb;
	JComboBox comboBoxGenre = new JComboBox();
	JYearChooser yearChooser = new JYearChooser();
	JComboBox comboBoxCategory=new JComboBox();
	
		

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				AddContent addcontent = new AddContent();
				addcontent.setVisible(true);
				
			
			}
		});
		
		
		btnNewButton.setBounds(494, 219, 110, 42);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(26, 24, 631, 163);
		frame.getContentPane().add(scrollPane);
		
	
		
		table = new JTable(new TblContentModel());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex=table.getSelectedRow();
				titlelb.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
				trailerlb.setText(table.getModel().getValueAt(selectedRowIndex, 3).toString());
				descriptionlb.setText(table.getModel().getValueAt(selectedRowIndex, 2).toString());
				Genre genre =(Genre) table.getModel().getValueAt(selectedRowIndex, 1);
				
				
				
				//int year = (int) table.getValueAt(selectedRowIndex, 4);
				//yearChooser.setValue(year);
				
				
				
				
			}
		});
		
		
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				List q=ContentServicesDelegate.findContentByTitle(title);
				Content c=(Content) q.get(0);
				ContentServicesDelegate.deleteContent(c);
				
				
				
			
			}
		});
		btnDelete.setBounds(494, 281, 110, 42);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Content contentFound = ContentServicesDelegate.findContentById(2);
				contentFound.setTitle(titlelb.getText());
				
				contentFound.setTrailer(trailerlb.getText());
				contentFound.setDescription(descriptionlb.getText());

				ContentServicesDelegate.updateContent(contentFound);
				
				Genre genre = (Genre) comboBoxGenre.getSelectedItem();
				int yearReleased=yearChooser.getComponentCount();
			   ////Double rating= (Double) spinner.getValue();
			  Category category = (Category) comboBoxCategory.getSelectedItem();
			 //// ContentServicesDelegate.updateContent(content);
			}
		});
		btnUpdate.setBounds(494, 349, 110, 40);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(26, 253, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		titlelb = new JTextField();
		titlelb.setBounds(86, 251, 86, 20);
		frame.getContentPane().add(titlelb);
		titlelb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Genre");
		lblNewLabel.setBounds(26, 281, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		//JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(new DefaultComboBoxModel(Genre.values()));
		comboBoxGenre.setBounds(86, 278, 86, 20);
		frame.getContentPane().add(comboBoxGenre);
		
		JLabel lblTrailer = new JLabel("Trailer");
		lblTrailer.setBounds(26, 309, 46, 14);
		frame.getContentPane().add(lblTrailer);
		
		trailerlb = new JTextField();
		trailerlb.setBounds(86, 306, 164, 20);
		frame.getContentPane().add(trailerlb);
		trailerlb.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(26, 337, 76, 14);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(260, 247, 46, 14);
		frame.getContentPane().add(lblRating);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(304, 241, 45, 20);
		frame.getContentPane().add(spinner);
		
		JComboBox comboBoxCategory = new JComboBox();
		comboBoxCategory.setModel(new DefaultComboBoxModel(Category.values()));
		comboBoxCategory.setBounds(314, 281, 63, 20);
		frame.getContentPane().add(comboBoxCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(260, 281, 46, 14);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblReleaseYear = new JLabel("Release Year");
		lblReleaseYear.setBounds(260, 315, 63, 14);
		frame.getContentPane().add(lblReleaseYear);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(339, 315, 53, 20);
		frame.getContentPane().add(yearChooser);
		
		descriptionlb = new JTextField();
		descriptionlb.setBounds(96, 337, 154, 52);
		frame.getContentPane().add(descriptionlb);
		descriptionlb.setColumns(10);
		
		


	}
}
