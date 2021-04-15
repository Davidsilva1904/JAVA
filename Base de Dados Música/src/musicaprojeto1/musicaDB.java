package musicaprojeto1;



import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class musicaDB {

	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel label;
	private JPanel contentPane;
	private static JFrame jframe;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/musica";
	static final String USER = "root";
	static final String PASS = null;
	static Connection conn = null;
	
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTable table_1;
	private JScrollPane scrollPane_1; 
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{             
			//Register JDBC driver             
			Class.forName("com.mysql.jdbc.Driver");             
			//Open a connection             
			System.out.println("Connecting to database...");             
			conn = DriverManager.getConnection(DB_URL,USER,PASS);             
			}             
			catch(ClassNotFoundException e)             {            
				System.out.println("Não foi possível carregar o driver de ligação à base de dados. Erro: " + e.getMessage());             
				System.exit(1); // saída com erro             
				}             
				catch(SQLException e)             {            
					System.out.println("Não foi possível ligar à base de dados. Erro: " + e.getMessage());            
					System.exit(1); // saída com erro             
					}             
					catch(Exception e)             {             
						System.out.println("Aconteceu um erro não identificado. Erro: " + e.getMessage());            
						System.exit(1); // saída com erro             
						}
				
		

			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musicaDB window = new musicaDB();
					window.jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 //APARECER OS DADOS INSERIDOS NA BASE DE DADOS DOS ARTISTAS
	 private void table_update() {
	        int CC;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            st = conn.prepareStatement("SELECT * FROM artista");
	            ResultSet Rs = st.executeQuery();
	            
	            java.sql.ResultSetMetaData RSMD = Rs.getMetaData();
	            CC = RSMD.getColumnCount();
	            DefaultTableModel DFT = (DefaultTableModel) table_1.getModel();
	            DFT.setRowCount(0);

	            while (Rs.next()) {
	                Vector v2 = new Vector();
	           
	                for (int ii = 1; ii <= CC; ii++) {
	                    v2.add(Rs.getString("id"));
	                    v2.add(Rs.getString("nome"));
	                    v2.add(Rs.getString("pais"));
	                    v2.add(Rs.getString("ano"));
	                }
	                DFT.addRow(v2);
	            }
	        } catch (Exception e) {
	        }
	    }
	 //APARECER OS DADOS INSERIDOS NA BASE DE DADOS DOS USUÁRIOS
	 private void table_update1() {
	        int CC;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            st = conn.prepareStatement("SELECT * FROM login");
	            ResultSet Rs = st.executeQuery();
	            
	            java.sql.ResultSetMetaData RSMD = Rs.getMetaData();
	            CC = RSMD.getColumnCount();
	            DefaultTableModel DFT = (DefaultTableModel) table_2.getModel();
	            DFT.setRowCount(0);

	            while (Rs.next()) {
	                Vector v2 = new Vector();
	           
	                for (int ii = 1; ii <= CC; ii++) {
	                    v2.add(Rs.getString("id"));
	                    v2.add(Rs.getString("nome"));
	                    v2.add(Rs.getString("password"));
	          
	                }
	                DFT.addRow(v2);
	            }
	        } catch (Exception e) {
	        }
	    }
	 //APARECER OS DADOS INSERIDOS NA BASE DE DADOS DOS ÁLBUNS
	 private void table_update2() {
	        int CC;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            st = conn.prepareStatement("SELECT * FROM album");
	            ResultSet Rs = st.executeQuery();
	            
	            java.sql.ResultSetMetaData RSMD = Rs.getMetaData();
	            CC = RSMD.getColumnCount();
	            DefaultTableModel DFT = (DefaultTableModel) table.getModel();
	            DFT.setRowCount(0);

	            while (Rs.next()) {
	                Vector v2 = new Vector();
	           
	                for (int ii = 1; ii <= CC; ii++) {
	                    v2.add(Rs.getString("id"));
	                    v2.add(Rs.getString("nome"));
	                    v2.add(Rs.getString("artista"));
	                    v2.add(Rs.getString("ano"));
	                }
	                DFT.addRow(v2);
	            }
	        } catch (Exception e) {
	        }
	    }
	/**
	 * Create the application.
	 */
	public musicaDB() {
		initialize();
	     table_update();
	     table_update1();
	     table_update2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jframe = new JFrame();
		jframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\depositphotos_156078370-stock-illustration-note-icon-illustration.jpg"));
		jframe.setTitle("MUSIC DATABASE");
		jframe.setBounds(100, 100, 791, 591);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.getContentPane().setLayout(new CardLayout(0, 0));
		
		   
		
		JPanel login = new JPanel();
		jframe.getContentPane().add(login, "name_22581256783600");
		login.setLayout(null);
				
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 28));
		textField_1.setBounds(184, 115, 414, 71);
		login.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SENHA:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(184, 235, 109, 23);
		login.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setBounds(184, 81, 109, 23);
		login.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.BOLD, 28));
		passwordField.setBounds(184, 269, 412, 71);
		login.add(passwordField);
		
		//panel inicial
		JPanel inicial = new JPanel();
		jframe.getContentPane().add(inicial, "name_22581271513900");
		inicial.setLayout(null);
		
		//panel inicial
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 775, 76);
		panel_4.setBackground(Color.BLACK);
		inicial.add(panel_4);
		panel_4.setLayout(null);
		
		//panel inicial
		lblNewLabel_2 = new JLabel("MUSIC DATABASE");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 0, 238, 76);
		panel_4.add(lblNewLabel_2);
		
		//panel inicial
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(236, 11, 51, 10);
		panel_4.add(panel_6);
		
		//panel inicial
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(236, 32, 51, 10);
		panel_4.add(panel_7);
		
		//panel inicial
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(236, 53, 51, 10);
		panel_4.add(panel_8);
		
		//panel inicial
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 76, 235, 436);
		panel_5.setBackground(Color.DARK_GRAY);
		inicial.add(panel_5);
		panel_5.setLayout(null);
		
		
		//panel inicial
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton.setBounds(0, 341, 235, 46);
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(true);
				inicial.setVisible(false);
			}
		});

		//panel inicial
		JButton btnNewButton_5 = new JButton("In\u00EDcio");
		btnNewButton_5.setBackground(SystemColor.controlDkShadow);
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(0, 89, 235, 46);
		panel_5.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 512, 775, 40);
		panel_14.setBackground(Color.GRAY);
		inicial.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("BASE DE DADOS MUSICA @ 2020");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("ROG Fonts", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(245, 0, 291, 40);
		panel_14.add(lblNewLabel_4);
		
		JLabel lblNewLabel_10 = new JLabel("IN\u00CDCIO");
		lblNewLabel_10.setBounds(253, 87, 320, 76);
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 39));
		inicial.add(lblNewLabel_10);
		
		
		
		JPanel artistas = new JPanel();
		artistas.setForeground(Color.WHITE);
		jframe.getContentPane().add(artistas, "name_23022940811300");
		artistas.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(0, 0, 775, 76);
		panel_17.setBackground(Color.BLACK);
		artistas.add(panel_17);
		panel_17.setLayout(null);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(236, 11, 51, 10);
		panel_17.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(236, 32, 51, 10);
		panel_17.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(236, 53, 51, 10);
		panel_17.add(panel_20);
		
		JLabel lblNewLabel_6 = new JLabel("MUSIC DATABASE");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(21, 0, 238, 76);
		panel_17.add(lblNewLabel_6);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(0, 76, 235, 436);
		panel_21.setBackground(Color.DARK_GRAY);
		artistas.add(panel_21);
		panel_21.setLayout(null);
		
		JButton btnNewButton_11 = new JButton("In\u00EDcio");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistas.setVisible(false);
				inicial.setVisible(true);
			}
		});
		btnNewButton_11.setBackground(SystemColor.controlDkShadow);
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_11.setBounds(0, 89, 235, 46);
		panel_21.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Artistas");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_12.setBackground(Color.GRAY);
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_12.setBounds(0, 134, 235, 46);
		panel_21.add(btnNewButton_12);
		

		
		
		JButton btnNewButton_15 = new JButton("SAIR");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				artistas.setVisible(false);
			}
		});
	
		btnNewButton_15.setBackground(Color.DARK_GRAY);
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_15.setBounds(0, 341, 235, 46);
		panel_21.add(btnNewButton_15);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBounds(0, 512, 775, 40);
		panel_22.setBackground(Color.GRAY);
		artistas.add(panel_22);
		panel_22.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("BASE DE DADOS MUSICA @ 2020");
		lblNewLabel_7.setFont(new Font("ROG Fonts", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(245, 0, 291, 40);
		panel_22.add(lblNewLabel_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(245, 246, 520, 255);
		artistas.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Arial", Font.PLAIN, 12));
		table_1.setBackground(Color.WHITE);
		table_1.setForeground(Color.BLACK);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "País", "Ano de Estreia"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 215, 118, 20);
		artistas.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(378, 215, 118, 20);
		artistas.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(513, 215, 118, 20);
		artistas.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(647, 215, 118, 20);
		artistas.add(textField_5);
		textField_5.setColumns(10);
		 
	
		//INSERIR ARTISTA
		JButton btnNewButton_21 = new JButton("INSERIR");
		btnNewButton_21.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\add.png"));
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				  String id = textField_2.getText();
				  String nome =textField_3.getText();
				  String pais =textField_4.getText();
				  String ano =textField_5.getText();
				  
				        try {
				            Class.forName("com.mysql.jdbc.Driver"); 
				            st = conn.prepareStatement("insert into artista (id,nome,pais,ano)values(?,?,?,?)");
				            st.setString(1,id);
				            st.setString(2,nome);
				            st.setString(3,pais);
				            st.setString(4,ano);
				            st.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Artista Adicionado");
				            
				            
				            
				            textField_2.setText("");
				            textField_3.setText("");
				            textField_4.setText("");
				            textField_5.setText("");
				            table_update();
				            
				            
				        } catch (SQLException e1) {
				        	e1.printStackTrace();
				        } catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
			
			}
		});
	
	
		
		btnNewButton_21.setBounds(304, 150, 125, 40);
		artistas.add(btnNewButton_21);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setBounds(245, 201, 126, 14);
		artistas.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Nome");
		lblNewLabel_12.setBounds(378, 201, 46, 14);
		artistas.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Pa\u00EDs");
		lblNewLabel_13.setBounds(513, 201, 46, 14);
		artistas.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Ano de Estreia");
		lblNewLabel_14.setBounds(647, 201, 118, 14);
		artistas.add(lblNewLabel_14);
		

		
		JPanel albuns = new JPanel();
		jframe.getContentPane().add(albuns, "name_26658333734900");
		albuns.setLayout(null);
		
		//panel inicial
		JButton btnNewButton_4 = new JButton("Artistas");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistas.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setBounds(0, 134, 235, 46);
		panel_5.add(btnNewButton_4);
		
		
		//panel inicial
		JButton btnNewButton_3 = new JButton("\u00C1lbuns");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albuns.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_3.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_3.setBounds(0, 179, 235, 46);
		panel_5.add(btnNewButton_3);
		
		
		JButton btnNewButton_13 = new JButton("\u00C1lbuns");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistas.setVisible(false);
				albuns.setVisible(true);
			}
		});
		btnNewButton_13.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_13.setBounds(0, 179, 235, 46);
		panel_21.add(btnNewButton_13);
		
			
		
		
	
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(0, 0, 775, 76);
		albuns.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("MUSIC DATABASE");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(21, 0, 238, 76);
		panel_9.add(lblNewLabel_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(236, 11, 51, 10);
		panel_9.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(236, 32, 51, 10);
		panel_9.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(236, 53, 51, 10);
		panel_9.add(panel_13);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.DARK_GRAY);
		panel_10.setBounds(0, 76, 235, 436);
		albuns.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Início");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albuns.setVisible(false);
				inicial.setVisible(true);
			}
		});
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(SystemColor.controlDkShadow);
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_6.setBounds(0, 89, 235, 46);
		panel_10.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Artistas");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(Color.GRAY);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albuns.setVisible(false);
				artistas.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_7.setBounds(0, 134, 235, 46);
		panel_10.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("\u00C1lbuns");
		
		btnNewButton_8.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_8.setBounds(0, 179, 235, 46);
		panel_10.add(btnNewButton_8);
		
		
		JButton btnNewButton_10 = new JButton("SAIR");
		btnNewButton_10.setBackground(Color.DARK_GRAY);
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				albuns.setVisible(false);
				login.setVisible(true);
			}
		});
		btnNewButton_10.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_10.setBounds(0, 341, 235, 46);
		panel_10.add(btnNewButton_10);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.GRAY);
		panel_15.setBounds(0, 512, 775, 40);
		albuns.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("BASE DE DADOS MUSICA @ 2020");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("ROG Fonts", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(245, 0, 291, 40);
		panel_15.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 246, 520, 255);
		albuns.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"ID", "Nome", "Artista", "Ano do Lançamento"
			
			}
	
		));
		scrollPane.setViewportView(table);
		
		JPanel usuários = new JPanel();
		jframe.getContentPane().add(usuários, "name_2243381986300");
		usuários.setLayout(null);
		//panel inicial
		JButton btnNewButton_2 = new JButton("Usu\u00E1rios");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuários.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_2.setBackground(SystemColor.scrollbar);
		btnNewButton_2.setBounds(0, 224, 235, 46);
		panel_5.add(btnNewButton_2);
		
		//panel inicial
		JButton btnNewButton_30 = new JButton("");
		btnNewButton_30.setBounds(245, 163, 251, 164);
		btnNewButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistas.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_30.setToolTipText("");
		btnNewButton_30.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\1.jpg"));
		inicial.add(btnNewButton_30);
		
		//panel inicial
		JButton btnNewButton_32 = new JButton("");
		btnNewButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuários.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_32.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\Sem T\u00EDtulo.png"));
		btnNewButton_32.setBounds(387, 338, 251, 164);
		inicial.add(btnNewButton_32);
		
		//panel inicial
		JButton btnNewButton_31 = new JButton("");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albuns.setVisible(true);
				inicial.setVisible(false);
			}
		});
		btnNewButton_31.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\Screenshot_15.png"));
		btnNewButton_31.setBounds(514, 163, 251, 164);
		inicial.add(btnNewButton_31);
		
		JButton btnNewButton_14 = new JButton("Usu\u00E1rios");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistas.setVisible(false);
				usuários.setVisible(true);
			}
		});
		btnNewButton_14.setBackground(SystemColor.scrollbar);
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_14.setBounds(0, 224, 235, 46);
		panel_21.add(btnNewButton_14);
		//EDITAR ARTISTA
		JButton btnNewButton_23 = new JButton("EDITAR");
		btnNewButton_23.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\refresh.png"));
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	            int selectedIndex = table_1.getSelectedRow();
	            try {   
	                
	            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
	            String nome =textField_3.getText();
	            String pais =textField_4.getText();
	            String ano =textField_5.getText();
	  
	            Class.forName("com.mysql.jdbc.Driver");
	            st = conn.prepareStatement("update artista set nome= ?,pais= ?,ano= ? where id= ?");
	            st.setString(1,nome);
	            st.setString(2,pais);
	            st.setString(3,ano);
	            st.setInt(4,id);
	            st.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Artista Atualizado");
	            textField_3.setText("");
	            textField_4.setText("");
	            textField_5.setText("");
	            table_update();
	           
	            
	        } catch (ClassNotFoundException ex) {
	           
	        } catch (SQLException ex) {

	        }
			}
		});
		btnNewButton_23.setBounds(445, 150, 125, 40);
		artistas.add(btnNewButton_23);
		//APAGAR ARTISTA
		JButton btnNewButton_24 = new JButton("APAGAR");
		btnNewButton_24.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\delete.png"));
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		          DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		          int selectedIndex = table_1.getSelectedRow();
		            try {   
		                
		            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		            int dialogResult = JOptionPane.showConfirmDialog (null, "Tem a certeza que quer eliminar o artista?","Atenção!",JOptionPane.YES_NO_OPTION);
		            if(dialogResult == JOptionPane.YES_OPTION){

		            Class.forName("com.mysql.jdbc.Driver");
		            st = conn.prepareStatement("delete from artista where id = ?");
		        
		            st.setInt(1,id);
		            st.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Artista Eliminado");
		            textField_3.setText("");
		            textField_4.setText("");
		            textField_5.setText("");

		            table_update();
		           
		           }

		        } catch (ClassNotFoundException ex) {
		        
		        } catch (SQLException ex) {
		            
		        }
			}
		});
		btnNewButton_24.setBounds(587, 150, 118, 40);
		artistas.add(btnNewButton_24);
		
		JLabel lblNewLabel_15 = new JLabel("ARTISTAS");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel_15.setBounds(245, 93, 179, 30);
		artistas.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Confira aqui a lista de artistas:");
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(245, 119, 216, 20);
		artistas.add(lblNewLabel_16);
		
		
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.BLACK);
		panel_23.setBounds(0, 0, 775, 76);
		usuários.add(panel_23);
		panel_23.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("MUSIC DATABASE");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(21, 0, 238, 76);
		panel_23.add(lblNewLabel_8);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBounds(236, 11, 51, 10);
		panel_23.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBounds(236, 32, 51, 10);
		panel_23.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBounds(236, 53, 51, 10);
		panel_23.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.DARK_GRAY);
		panel_27.setBounds(0, 76, 235, 436);
		usuários.add(panel_27);
		panel_27.setLayout(null);
		
		JButton btnNewButton_16 = new JButton("In\u00EDcio");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						usuários.setVisible(false);
						inicial.setVisible(true);
					}

		});
		btnNewButton_16.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_16.setBackground(SystemColor.controlDkShadow);
		btnNewButton_16.setForeground(Color.WHITE);
		
		btnNewButton_16.setBounds(0, 89, 235, 46);
		panel_27.add(btnNewButton_16);
		
		JButton btnNewButton_9 = new JButton("Usu\u00E1rios");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albuns.setVisible(false);
				usuários.setVisible(true);
			}
		});
		btnNewButton_9.setBackground(SystemColor.scrollbar);
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_9.setBounds(0, 224, 235, 46);
		panel_10.add(btnNewButton_9);
		//INSERIR ÁLBUNS
		JButton btnNewButton_27 = new JButton("INSERIR");
		btnNewButton_27.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\add.png"));
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_9.getText();
				  String nome =textField_10.getText();
				  String artista =textField_11.getText();
				  String ano =textField_12.getText();
				  
				        try {
				            Class.forName("com.mysql.jdbc.Driver"); 				            
				            st = conn.prepareStatement("insert into album (id,nome,artista,ano)values(?,?,?,?)");
				            st.setString(1,id);
				            st.setString(2,nome);
				            st.setString(3,artista);
				            st.setString(4,ano);
				            st.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Álbum Adicionado");
				            
				            
				            
				            textField_9.setText("");
				            textField_10.setText("");
				            textField_11.setText("");
				            textField_12.setText("");
				            table_update2();
				            
				            
				        } catch (SQLException e1) {
				        	e1.printStackTrace();
				        } catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
			}
		});
		btnNewButton_27.setBounds(304, 150, 125, 40);
		albuns.add(btnNewButton_27);
		//EDITAR ÁLBUNS
		JButton btnNewButton_28 = new JButton("EDITAR");
		btnNewButton_28.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\refresh.png"));
		btnNewButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  DefaultTableModel model = (DefaultTableModel) table.getModel();
		            int selectedIndex = table.getSelectedRow();
		            try {   
		                
		            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		            String nome =textField_10.getText();
		            String artista =textField_11.getText();
		            String ano =textField_12.getText();
		  
		            Class.forName("com.mysql.jdbc.Driver");		         
		            st = conn.prepareStatement("update album set nome= ?,artista= ?,ano= ? where id= ?");
		            st.setString(1,nome);
		            st.setString(2,artista);
		            st.setString(3,ano);
		            st.setInt(4,id);
		            st.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Álbum Atualizado");
		            textField_10.setText("");
		            textField_11.setText("");
		            textField_12.setText("");
		            table_update2();
		           
		            
		        } catch (ClassNotFoundException ex) {
		           
		        } catch (SQLException ex) {

		        }
			}
		});
		btnNewButton_28.setBounds(445, 150, 125, 40);
		albuns.add(btnNewButton_28);
		//APAGAR ÁLBUNS
		JButton btnNewButton_29 = new JButton("APAGAR");
		btnNewButton_29.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\delete.png"));
		btnNewButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		          int selectedIndex = table.getSelectedRow();
		            try {   
		                
		            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		            int dialogResult = JOptionPane.showConfirmDialog (null, "Tem a certeza que quer eliminar o Álbum?","Atenção!",JOptionPane.YES_NO_OPTION);
		            if(dialogResult == JOptionPane.YES_OPTION){

		            Class.forName("com.mysql.jdbc.Driver");		            
		            st = conn.prepareStatement("delete from album where id = ?");
		        
		            st.setInt(1,id);
		            st.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Álbum Eliminado");
		            textField_10.setText("");
		            textField_11.setText("");
		            textField_12.setText("");

		            table_update2();
		           
		           }

		        } catch (ClassNotFoundException ex) {
		        
		        } catch (SQLException ex) {
		            
		        }
			}
		});
		btnNewButton_29.setBounds(587, 150, 118, 40);
		albuns.add(btnNewButton_29);
		
		textField_9 = new JTextField();
		textField_9.setBounds(245, 215, 118, 20);
		albuns.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(378, 215, 118, 20);
		albuns.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(513, 215, 118, 20);
		albuns.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(647, 215, 118, 20);
		albuns.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("ID");
		lblNewLabel_17.setBounds(245, 201, 46, 14);
		albuns.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("\u00C1LBUNS");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel_18.setBounds(245, 93, 179, 30);
		albuns.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Confira aqui a lista de \u00E1lbuns:");
		lblNewLabel_19.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_19.setBounds(245, 119, 216, 20);
		albuns.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Nome");
		lblNewLabel_20.setBounds(378, 201, 46, 14);
		albuns.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Artista");
		lblNewLabel_21.setBounds(513, 201, 46, 14);
		albuns.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Ano de Lan\u00E7amento");
		lblNewLabel_22.setBounds(647, 201, 118, 14);
		albuns.add(lblNewLabel_22);
		
		JButton btnNewButton_17 = new JButton("Artistas");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuários.setVisible(false);
				artistas.setVisible(true);
			}
		});
		btnNewButton_17.setBackground(Color.GRAY);
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_17.setBounds(0, 134, 235, 46);
		panel_27.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("\u00C1lbuns");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuários.setVisible(false);
				albuns.setVisible(true);
			}
		});
		btnNewButton_18.setForeground(Color.WHITE);
		btnNewButton_18.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_18.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_18.setBounds(0, 179, 235, 46);
		panel_27.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("Usu\u00E1rios");
		btnNewButton_19.setBackground(SystemColor.scrollbar);
		btnNewButton_19.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_19.setForeground(Color.WHITE);
		btnNewButton_19.setBounds(0, 224, 235, 46);
		panel_27.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("SAIR");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuários.setVisible(false);
				login.setVisible(true);
			}
		});
		btnNewButton_20.setBackground(Color.DARK_GRAY);
		btnNewButton_20.setForeground(Color.WHITE);
		btnNewButton_20.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_20.setBounds(0, 341, 235, 46);
		panel_27.add(btnNewButton_20);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.GRAY);
		panel_28.setBounds(0, 512, 775, 40);
		usuários.add(panel_28);
		panel_28.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("BASE DE DADOS MUSICA @ 2020");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("ROG Fonts", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(245, 0, 291, 40);
		panel_28.add(lblNewLabel_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(245, 246, 520, 255);
		usuários.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Arial", Font.PLAIN, 12));
		table_2.setForeground(Color.BLACK);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Nome", "Password"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(279, 215, 116, 20);
		usuários.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(445, 215, 116, 20);
		usuários.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(616, 215, 116, 20);
		usuários.add(textField_8);
		textField_8.setColumns(10);
		//ADICIONAR USUÁRIO
		JButton btnNewButton_22 = new JButton("INSERIR");
		btnNewButton_22.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\add.png"));
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_6.getText();
				  String nome = textField_7.getText();
				  String password = textField_8.getText();
				  
				  
				        try {
				            Class.forName("com.mysql.jdbc.Driver"); 
				            st = conn.prepareStatement("insert into login (id,nome,password)values(?,?,?)");
				            st.setString(1,id);
				            st.setString(2,nome);
				            st.setString(3,password);
				            st.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Usuário Adicionado");
				            
				            
				            
				            textField_6.setText("");
				            textField_7.setText("");
				            textField_8.setText("");
				            table_update1();
				            
				            
				        } catch (SQLException e1) {
				        	e1.printStackTrace();
				        } catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
			
			}
		});
	
	
		
		btnNewButton_22.setBounds(304, 150, 125, 40);
		usuários.add(btnNewButton_22);
		//APAGAR USUÁRIOS
		JButton btnNewButton_25 = new JButton("APAGAR");
		btnNewButton_25.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\delete.png"));
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		          int selectedIndex = table_2.getSelectedRow();
		            try {   
		                
		            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		            int dialogResult = JOptionPane.showConfirmDialog (null, "Tem a certeza que quer eliminar o Usuário?","Atenção!",JOptionPane.YES_NO_OPTION);
		            if(dialogResult == JOptionPane.YES_OPTION){

		            Class.forName("com.mysql.jdbc.Driver");
		            st = conn.prepareStatement("delete from login where id = ?");
		        
		            st.setInt(1,id);
		            st.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Usuário Eliminado");
		            textField_6.setText("");
		            textField_7.setText("");
		            textField_8.setText("");

		            table_update1();
		           
		           }

		        } catch (ClassNotFoundException ex) {
		        
		        } catch (SQLException ex) {
		            
		        }
			}
		});
		btnNewButton_25.setBounds(587, 150, 118, 40);
		usuários.add(btnNewButton_25);
		//EDITAR USUÁRIOS
		JButton btnNewButton_26 = new JButton("EDITAR");
		btnNewButton_26.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\musicaprojeto1\\icon\\refresh.png"));
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	            int selectedIndex = table_2.getSelectedRow();
	            try {   
	                
	            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
	            String nome =textField_7.getText();
	            String password =textField_8.getText();
	            
	  
	            Class.forName("com.mysql.jdbc.Driver");
	            st = conn.prepareStatement("update login set nome= ?,password= ? where id= ?");
	            st.setString(1,nome);
	            st.setString(2,password);
	            st.setInt(3,id);	           
	            st.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Usuário Atualizado");
	            textField_7.setText("");
	            textField_8.setText("");
	            table_update1();
	           
	            
	        } catch (ClassNotFoundException ex) {
	           
	        } catch (SQLException ex) {

	        }
			}
		});
		btnNewButton_26.setBounds(445, 150, 125, 40);
		usuários.add(btnNewButton_26);
		
		JLabel lblNewLabel_23 = new JLabel("ID");
		lblNewLabel_23.setBounds(279, 201, 46, 14);
		usuários.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Nome");
		lblNewLabel_24.setBounds(445, 201, 46, 14);
		usuários.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Password");
		lblNewLabel_25.setBounds(616, 201, 64, 14);
		usuários.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("USU\u00C1RIOS");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel_26.setBounds(245, 93, 179, 30);
		usuários.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Confira aqui a lista de usu\u00E1rios:");
		lblNewLabel_27.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_27.setBounds(245, 119, 216, 20);
		usuários.add(lblNewLabel_27);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 55, 552);
		login.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(54, 0, 55, 552);
		login.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(108, 0, 55, 552);
		login.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(720, 0, 67, 552);
		login.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(610, 0, 55, 552);
		login.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(665, 0, 55, 552);
		login.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.BLACK);
		panel_16.setBounds(163, 504, 449, 48);
		login.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("BASE DE DADOS MUSICA @ 2020");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("ROG Fonts", Font.PLAIN, 14));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(84, 0, 304, 48);
		panel_16.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_28 = new JLabel("MUSIC DATABASE");
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_28.setBounds(265, 22, 238, 37);
		login.add(lblNewLabel_28);
		
		//panel login
		JButton btnNewButton_33 = new JButton("SAIR");
		btnNewButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_33.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_33.setBounds(409, 365, 187, 98);
		login.add(btnNewButton_33);
		
		
		//panel login
		//LOGAR APARTIR DOS USUÁRIOS DA BASE DE DADOS
		JButton btnNewButton_1 = new JButton("LOGAR");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 28));
		btnNewButton_1.setBounds(184, 365, 187, 98);
		login.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
						
				
				String nome=textField_1.getText();
				String pass=passwordField.getText();
				
				String query="select * from login where nome=? and password=?";
				PreparedStatement statement = conn.prepareStatement (query);
				statement.setString(1, nome);
				statement.setString(2, pass);
				
				ResultSet set=statement.executeQuery();
				if(set.next())
				
				{
					JOptionPane.showMessageDialog(null, "Secção Iniciada, Bem-Vindo!");
					login.setVisible(false);
					inicial.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "A Sua Password ou Nome estão Incorretos! Tente Novamente!");
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
	}
}

