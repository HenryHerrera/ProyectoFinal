package gt.edu.umg.proma1.proyectofinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextPane;

public class Base extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntidad;
	private JTextField txtAtributo;
	private JTextField txtLongitud;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtTipoDato;


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

	public int getSumaAscii(String linea) {
		int total = 0;
		for (int i = 0; i < linea.length(); i++) {
			char c = linea.charAt(i);
			int ascii = (int) c;
			total += ascii;
		}
		int id = (total % 50);
		return id;
	}

	private boolean verificarColosion(int id) {
		boolean existe = false;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			String valor = tableModel.getValueAt(i, 0).toString();
			if (id == Integer.parseInt(valor)) {
				existe = true;
				break;
			}

		}
		return existe;
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
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Entidad");
		tableModel.addColumn("Atributo");
		tableModel.addColumn("Tipo de Dato");
		tableModel.addColumn("Longitud");
		table = new JTable();
		table.setBounds(62, 270, 475, 170);
		contentPane.add(table);

		JLabel lblEntidad = new JLabel("Nombre Entidad:");
		lblEntidad.setBounds(35, 11, 103, 21);
		contentPane.add(lblEntidad);

		txtEntidad = new JTextField();
		txtEntidad.setBounds(168, 11, 126, 21);
		contentPane.add(txtEntidad);
		txtEntidad.setColumns(10);

		JLabel lblAtributo = new JLabel("Nombre del Atributo:");
		lblAtributo.setBounds(35, 43, 126, 21);
		contentPane.add(lblAtributo);

		txtAtributo = new JTextField();
		txtAtributo.setBounds(168, 43, 126, 21);
		contentPane.add(txtAtributo);
		txtAtributo.setColumns(10);

		JLabel lblTipoDato = new JLabel("Ingrese Tipo de Dato:");
		lblTipoDato.setBounds(35, 75, 126, 29);
		contentPane.add(lblTipoDato);
		
		txtTipoDato = new JTextField();
		txtTipoDato.setBounds(168, 79, 126, 21);
		contentPane.add(txtTipoDato);
		txtTipoDato.setColumns(10);

		JLabel lblLongitud = new JLabel("Ingrese la Longitud:");
		lblLongitud.setBounds(35, 129, 125, 21);
		contentPane.add(lblLongitud);

		txtLongitud = new JTextField();
		txtLongitud.setBounds(168, 129, 72, 21);
		contentPane.add(txtLongitud);
		txtLongitud.setColumns(10);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = getSumaAscii(txtEntidad.getText().trim());
				if (verificarColosion(id)) {
					JOptionPane.showMessageDialog(null, "La Entidad ya Existe", "Duplicidad de informacion",
							JOptionPane.ERROR_MESSAGE);

				} else {
					Atributos a = new Atributos();
					a.setId(id);
					a.setEntidad(txtEntidad.getText().trim());
					a.setAtributo(txtAtributo.getText().trim());
					a.setTipoDato(txtTipoDato.getText().length());
					a.setLongitud(txtLongitud.getText().length());
					
					tableModel.addRow(new Object[] { a.getId(), a.getEntidad(), a.getAtributo(), a.getTipoDato(),
							a.getLongitud() });
					txtEntidad.setText("");
					txtAtributo.setText("");
					txtLongitud.setText("");
					txtTipoDato.setText(" ");

				}

			}
		});
		btnAgregar.setBounds(35, 200, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(183, 200, 89, 23);
		contentPane.add(btnModificar);
		
	
	}
}
