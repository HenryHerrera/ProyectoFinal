package gt.edu.umg.proma1.proyectofinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Base extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntidad;
	private JTextField txtAtributo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Base frame = new Base();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Base() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntidad = new JLabel("Nombre Entidad:");
		lblEntidad.setBounds(36, 28, 103, 21);
		contentPane.add(lblEntidad);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(168, 28, 126, 21);
		contentPane.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		JLabel lblAtributo = new JLabel("Nombre del Atributo:");
		lblAtributo.setBounds(35, 72, 126, 21);
		contentPane.add(lblAtributo);
		
		txtAtributo = new JTextField();
		txtAtributo.setBounds(168, 72, 126, 21);
		contentPane.add(txtAtributo);
		txtAtributo.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(168, 112, 126, 21);
		contentPane.add(comboBox);
		
		JLabel lblTipoDato = new JLabel("Ingrese Tipo de Dato:");
		lblTipoDato.setBounds(35, 108, 126, 29);
		contentPane.add(lblTipoDato);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(364, 27, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(364, 71, 89, 23);
		contentPane.add(btnModificar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Entidad", "Atributo", "Tipo de Dato", "Longitud"
			}
		));
		table.setBounds(60, 220, 547, 170);
		contentPane.add(table);
	}
}
