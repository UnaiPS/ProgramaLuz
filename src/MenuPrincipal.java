import java.awt.Color;
import java.awt.Container;
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
	
	private final Container[] arrayContainers;

    MenuPrincipal() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(7, 1));
		
		arrayContainers = new Container[6];
		for(int i=0; i<6; i++)  {
			arrayContainers[i] = new Container();
			arrayContainers[i].setLayout(new GridLayout(1, 2));

			JTextField nombre = new JTextField();
			nombre.setFont(Constants.FUENTE_NEGRITA);
			nombre.setHorizontalAlignment(JTextField.CENTER);
			nombre.setEditable(false);
			nombre.setFocusable(false);
			JTextField campo = new JTextField();
			campo.setFont(Constants.FUENTE_NEGRITA);
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
				nombre.setText(Constants.KWH_CONSUMIDOS);
				nombre.setToolTipText(Constants.KHW_CONSUMIDOS_TP);
				break;
			case 1:
				nombre.setText(Constants.NUM_DIAS);
				nombre.setToolTipText(Constants.NUM_DIAS_TP);
				break;
			case 2:
				nombre.setText(Constants.KW_CONTRATADOS);
				nombre.setToolTipText(Constants.KW_CONTRATADOS_TP);
				break;
			case 3:
				nombre.setText(Constants.KW_PER_EURO);
				nombre.setToolTipText(Constants.KW_PER_EURO_TP);
				campo.setText(String.valueOf(Constants.KW_EUROS));
				break;
			case 4:
				nombre.setText(Constants.KWH_PER_EURO);
				nombre.setToolTipText(Constants.KWH_PER_EURO_TP);
				campo.setText(String.valueOf(Constants.KWH_EUROS));
				break;
			case 5:
				nombre.setText(Constants.RESULT);
				nombre.setToolTipText(Constants.RESULT_TP);
				campo.setEditable(false);
				campo.setBackground(Color.WHITE);
				campo.setFocusable(false);
				break;
			}
		}

        JButton botonCalc = new JButton();
		botonCalc.setFont(Constants.FUENTE_NEGRITA);
		botonCalc.setText(Constants.CALCULAR);
		botonCalc.setActionCommand(Constants.CALCULAR_ACTION);
		botonCalc.setHorizontalAlignment(JTextField.CENTER);
		botonCalc.addActionListener(this);
		botonCalc.addKeyListener(this);
		cp.add(botonCalc);
		
		this.setSize(500, 300);
		this.setTitle(Constants.TITLE);
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
		String resultado = Constants.ERROR;
		if(!campoKwh.getText().isEmpty() && !campoDias.getText().isEmpty()) {
			int kwh;
			int dias;
			double potencia;
			double kwEur;
			double kwhEur;
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
				resultado = res + Constants.EUR_SYMBOL;
			}
		} else {
			resultado = Constants.ERROR_MSG;
		}
		
		campoRes.setText(resultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Constants.CALCULAR_ACTION)) {
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
