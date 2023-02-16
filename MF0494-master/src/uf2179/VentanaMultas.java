package uf2179;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private final ButtonGroup grupoPago = new ButtonGroup();
	private JComboBox comboBox;
	private JLabel lblImporte;
	private JRadioButton rbtNormal;
	private JRadioButton rbtPronto;
	private JTextArea textArea;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
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
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow,right][grow][][grow]", "[][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("DGT - Infracciones");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel, "cell 0 0 5 1,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Matrícula:");
		contentPane.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 2 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_2, "cell 3 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 4 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		contentPane.add(lblNewLabel_3, "cell 1 2,alignx trailing");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 2 2 3 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sanción:");
		contentPane.add(lblNewLabel_4, "cell 1 3,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiaSancion();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No llevar casco", "Conducción temeraria"}));
		contentPane.add(comboBox, "cell 2 3 3 1,growx");
		
		JLabel lblNewLabel_5 = new JLabel("Importe:");
		contentPane.add(lblNewLabel_5, "cell 1 4");
		
		lblImporte = new JLabel("200");
		contentPane.add(lblImporte, "cell 2 4");
		
		rbtNormal = new JRadioButton("Pago Normal");
		rbtNormal.setFont(new Font("Tahoma", Font.BOLD, 10));
		grupoPago.add(rbtNormal);
		rbtNormal.setSelected(true);
		contentPane.add(rbtNormal, "cell 2 5");
		
		rbtPronto = new JRadioButton("Pronto Pago");
		rbtPronto.setFont(new Font("Tahoma", Font.BOLD, 10));
		grupoPago.add(rbtPronto);
		contentPane.add(rbtPronto, "cell 3 5");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMensaje();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(btnAceptar, "cell 1 6 4 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 7 4 1,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	protected void mostrarMensaje() {
		
		// lanza un mensaje si los datos no están rellenados
		if(txtNombre.getText()==null || txtNombre.getText().isBlank() ||
				txtApellidos.getText()==null || txtApellidos.getText().isBlank() ||
				txtMatricula.getText()==null || txtMatricula.getText().isBlank()) {
			JOptionPane.showMessageDialog(comboBox, "Debe rellenar todos los campos", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		textArea.setText("");
		
		String conductor=txtNombre.getText()+" "+txtApellidos.getText();
		String infraccion=(String) comboBox.getSelectedItem();
		String importe= lblImporte.getText();
		
		textArea.setText("Conductor: "+conductor
				+"\nInfracción: "+infraccion
				+"\nImporte: "+importe);
		if(rbtPronto.isSelected()) {
			double importePronto=Integer.parseInt(importe)/2.0;
			textArea.setText(textArea.getText()+
					"\nPronto pago: "+importePronto);
		}
	}

	protected void cambiaSancion() {
		String sancion = (String) comboBox.getSelectedItem();
		
		if(sancion.equals("No llevar casco")) {
			lblImporte.setText(""+200);
		} else if(sancion.equals("Conducción temeraria")) {
			lblImporte.setText(""+500);
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

}
