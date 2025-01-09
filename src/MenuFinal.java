import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

import static java.lang.Math.round;

public class MenuFinal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Font fuente = new Font("Verdana", Font.PLAIN, 12);
	private static final Font fuenteNegrita = new Font("Verdana", Font.BOLD, 12);
	private static final Color color = new Color(155, 128, 32);
	private static final Border borde = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);
	
	private JTextField[][] campos;
	
	MenuFinal(double kwEuros, double kwhEuros, double impuesto, double equipos, double urgencias, double iva, int kwh, int dias, double potencia) {
		long tmp;

		//potenciaFac
		double potenciaFac = potencia * dias * kwEuros * 100;
		tmp = round(potenciaFac);
		potenciaFac = (double) tmp / 100;

		//energiaFac
		double energiaFac = kwh*kwhEuros *100;
		tmp = round(energiaFac);
		energiaFac = (double) tmp / 100;

		//impuestoFac
		double impuestoFac = 100*(potenciaFac+energiaFac)*impuesto/100;
		tmp = round(impuestoFac);
		impuestoFac = (double) tmp / 100;

		//totalEnergia
		double totalEnergia = (potenciaFac + energiaFac + impuestoFac)*100;
		tmp = round(totalEnergia);
		totalEnergia = (double) tmp / 100;

		//alquilerFac
		double alquilerFac = dias*equipos*100;
		tmp = round(alquilerFac);
		alquilerFac = (double) tmp / 100;

		//urgenciasFac
		double urgenciasFac =  round(((double) dias / 30) *urgencias * 100);
		tmp = round(urgenciasFac);
		urgenciasFac = (double) tmp / 100;

		//totalServicios
		double totalServicios = (alquilerFac + urgenciasFac)*100;
		tmp = round(totalServicios);
		totalServicios = (double) tmp / 100;

		//importeTotal
		double importeTotal = (totalEnergia + totalServicios)*100;
		tmp = round(importeTotal);
		importeTotal = (double) tmp / 100;

		//ivaFac
		double ivaFac = 100*importeTotal*iva/100;
		tmp = round(ivaFac);
		ivaFac = (double) tmp / 100;

		//res
		double res = (importeTotal + ivaFac)*100;
		tmp = round(res);
		res = (double) tmp / 100;
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(14, 3));
		campos = new JTextField[14][3];
		
		for(int linea=0; linea<14; linea++) {
			for(int col=0; col<3; col++) {
				campos[linea][col] = new JTextField();
				campos[linea][col].setFocusable(false);
				campos[linea][col].setEditable(false);
				campos[linea][col].setFont(fuente);
				campos[linea][col].setBackground(Color.WHITE);
				campos[linea][col].setBorder(null);
				cp.add(campos[linea][col]);
				if(col == 2) {
					campos[linea][col].setHorizontalAlignment(JTextField.RIGHT);
				}
				if(linea == 4 || linea == 9 || linea == 13) {
					campos[linea][col].setBorder(borde);
					campos[linea][col].setFont(fuenteNegrita);
					campos[linea][col].setForeground(color);
				}
				if(linea == 11 || linea == 12 || linea == 13) {
					campos[linea][col].setBackground(new Color(222, 222, 255));
				}
			}
		}
		campos[0][0].setFont(fuenteNegrita);
		campos[0][0].setText("ENERGÍA");
		
		campos[1][0].setText("Potencia facturada");
		campos[1][1].setText(potencia + " kW x " + dias + " días x " + kwEuros + " €/kW día");
		campos[1][2].setText(potenciaFac + " €");
		
		campos[2][0].setText("Energía facturada");
		campos[2][1].setText(kwh + " kWh x " + kwhEuros + " €/kWh");
		campos[2][2].setText(energiaFac + " €");
		
		campos[3][0].setText("Impuesto sobre electricidad");
		campos[3][1].setText(impuesto + "% s/" + (potenciaFac + energiaFac) + " €");
		campos[3][2].setText(impuestoFac + " €");
		
		campos[4][0].setText("TOTAL ENERGÍA");
		campos[4][2].setText(totalEnergia+" €");
		
		campos[6][0].setFont(fuenteNegrita);
		campos[6][0].setText("SERVICIOS Y OTROS CONCEPTOS");
		
		campos[7][0].setText("Alquiler equipos medida");
		campos[7][1].setText(dias+" días x "+equipos+" €/día");
		campos[7][2].setText(alquilerFac+" €");
		
		campos[8][0].setText("Protección eléctrica hogar");
		DecimalFormat df = new DecimalFormat("#.##");
		campos[8][1].setText( df.format(((double) dias / 30)) + " mes x " + urgencias + " €/mes");
		campos[8][2].setText(urgenciasFac + " €");
		
		campos[9][0].setText("TOTAL SERVICIOS Y OTROS CONCEPTOS");
		campos[9][2].setText(totalServicios + " €");
		
		campos[11][0].setText("IMPORTE TOTAL");
		campos[11][2].setText(importeTotal + " €");
		
		campos[12][0].setText("IVA");
		campos[12][1].setText(iva + "% s/" + importeTotal + " €");
		campos[12][2].setText(ivaFac + " €");
		
		campos[13][0].setText("TOTAL IMPORTE FACTURA");
		campos[13][2].setText(res + " €");
		
		this.pack();
		this.setTitle("Calcular factura");
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		this.setVisible(true);
	}
}
