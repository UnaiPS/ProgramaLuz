import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MenuPrincipal extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private static final Font fuente = new Font("Verdana", Font.BOLD, 12);
	
	private Container[] arrayContainers;
	private JButton botonCalc;
	
	MenuPrincipal() {				
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(7, 1));
		
		arrayContainers = new Container[6];
		for(int i=0; i<6; i++)  {
			arrayContainers[i] = new Container();
			arrayContainers[i].setLayout(new GridLayout(1, 2));

			JTextField nombre = new JTextField();
			nombre.setFont(fuente);
			nombre.setHorizontalAlignment(JTextField.CENTER);
			nombre.setEditable(false);
			nombre.setFocusable(false);
			JTextField campo = new JTextField();
			campo.setFont(fuente);
			campo.addKeyListener(this);
			campo.addFocusListener(new java.awt.event.FocusAdapter() {
			    public void focusGained(final java.awt.event.FocusEvent evt) {
			        SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                JTextField cam = (JTextField) evt.getComponent();
			                cam.selectAll();
			            }
			        });
			    }
			});
			arrayContainers[i].add(nombre);
			arrayContainers[i].add(campo);
			
			cp.add(arrayContainers[i]);
			
			switch(i) {
			case 0:
				nombre.setText("kWh consumidos:");
				nombre.setToolTipText("Cantidad de kWh consumidos");
				break;
			case 1:
				nombre.setText("Número de días:");
				nombre.setToolTipText("Número de días");
				break;
			case 2:
				nombre.setText("Potencia contratada (kW):");
				nombre.setToolTipText("Potencia contratada (kW)");
				break;
			case 3:
				nombre.setText("Potencia (kw/€):");
				nombre.setToolTipText("Potencia kw por euro (kw/€)");
				campo.setText(String.valueOf(Constants.kwEuros));
				break;
			case 4:
				nombre.setText("Energía (kwh/€):");
				nombre.setToolTipText("Potencia kwh por euro (kwh/€)");
				campo.setText(String.valueOf(Constants.kwhEuros));
				break;
			case 5:
				nombre.setText("Resultado:");
				nombre.setToolTipText("Resultado");
				campo.setEditable(false);
				campo.setBackground(Color.WHITE);
				campo.setFocusable(false);
				break;
			}
		}
		
		botonCalc = new JButton();
		botonCalc.setFont(fuente);
		botonCalc.setText("Calcular");
		botonCalc.setActionCommand("calcular");
		botonCalc.setHorizontalAlignment(JTextField.CENTER);
		botonCalc.addActionListener(this);
		botonCalc.addKeyListener(this);
		cp.add(botonCalc);
		
		this.setSize(500, 300);
		this.setTitle("Calcular factura");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		this.setVisible(true);
	}
	
	private void calcular() {
		JTextField campoKwh = (JTextField) arrayContainers[0].getComponent(1);
		JTextField campoDias = (JTextField) arrayContainers[1].getComponent(1);
		JTextField campoPotencia = (JTextField) arrayContainers[2].getComponent(1);
		JTextField campoKwEuros = (JTextField) arrayContainers[3].getComponent(1);
		JTextField campoKwhEuros = (JTextField) arrayContainers[4].getComponent(1);
		JTextField campoRes = (JTextField) arrayContainers[5].getComponent(1);
		String resultado = "Error.";
		if(!campoKwh.getText().isEmpty() && !campoDias.getText().isEmpty()) {
			int kwh = 0;
			int dias = 0;
			double potencia = 0;
			double kwEur = 0;
			double kwhEur = 0;
			try {
				kwh = Integer.parseInt(campoKwh.getText());
				dias = Integer.parseInt(campoDias.getText());
				potencia = Double.parseDouble(campoPotencia.getText().replace(",", "."));
				kwEur = Double.parseDouble(campoKwEuros.getText().replace(",", "."));
				kwhEur = Double.parseDouble(campoKwhEuros.getText().replace(",", "."));
			} catch(Exception ex) {
				kwh = 0;
				dias = 0;
				potencia = 0;
				kwEur = 0;
				kwhEur = 0;
			}
			if(kwh > 0 && dias > 0 && potencia > 0) {
				double res = Factura.calcular(kwh, dias, potencia, kwEur, kwhEur);
				resultado = res + "€";
			}
		} else {
			resultado = "Debes introducir los valores!";
		}
		
		campoRes.setText(resultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("calcular")) {
			calcular();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			calcular();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
