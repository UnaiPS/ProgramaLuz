import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MenuFinal extends JFrame {

    MenuFinal(double kwEuros, double kwhEuros, double impuesto, double equipos, double urgencias, double iva, int kwh, int dias, double potencia) {

		//potenciaFac
		double potenciaFac = potencia * dias * kwEuros * Constants.CIEN;
		potenciaFac = Utils.roundAndDivideByHundred(potenciaFac);

		//energiaFac
		double energiaFac = kwh*kwhEuros * Constants.CIEN;
		energiaFac = Utils.roundAndDivideByHundred(energiaFac);

		//impuestoFac
		double impuestoFac = Constants.CIEN * (potenciaFac + energiaFac) * impuesto / Constants.CIEN;
		impuestoFac = Utils.roundAndDivideByHundred(impuestoFac);

		//totalEnergia
		double totalEnergia = (potenciaFac + energiaFac + impuestoFac) * Constants.CIEN;
		totalEnergia = Utils.roundAndDivideByHundred(totalEnergia);

		//alquilerFac
		double alquilerFac = dias*equipos * Constants.CIEN;
		alquilerFac = Utils.roundAndDivideByHundred(alquilerFac);

		//urgenciasFac
		double urgenciasFac =  (Utils.calcularMes(dias) * urgencias * Constants.CIEN);
		urgenciasFac = Utils.roundAndDivideByHundred(urgenciasFac);

		//totalServicios
		double totalServicios = (alquilerFac + urgenciasFac) * Constants.CIEN;
		totalServicios = Utils.roundAndDivideByHundred(totalServicios);

		//importeTotal
		double importeTotal = (totalEnergia + totalServicios) * Constants.CIEN;
		importeTotal = Utils.roundAndDivideByHundred(importeTotal);

		//ivaFac
		double ivaFac = Constants.CIEN * importeTotal * iva / Constants.CIEN;
		ivaFac = Utils.roundAndDivideByHundred(ivaFac);

		//res
		double res = (importeTotal + ivaFac)*Constants.CIEN;
		res = Utils.roundAndDivideByHundred(res);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(14, 3));
        JTextField[][] campos = new JTextField[14][3];
		
		for(int linea=0; linea<14; linea++) {
			for(int col=0; col<3; col++) {
				campos[linea][col] = new JTextField();
				campos[linea][col].setFocusable(false);
				campos[linea][col].setEditable(false);
				campos[linea][col].setFont(Constants.FUENTE);
				campos[linea][col].setBackground(Color.WHITE);
				campos[linea][col].setBorder(null);
				cp.add(campos[linea][col]);
				if(col == 2) {
					campos[linea][col].setHorizontalAlignment(JTextField.RIGHT);
				}
				if(linea == 4 || linea == 9 || linea == 13) {
					campos[linea][col].setBorder(Constants.BORDE);
					campos[linea][col].setFont(Constants.FUENTE_NEGRITA);
					campos[linea][col].setForeground(Constants.COLOR);
				}
				if(linea == 11 || linea == 12 || linea == 13) {
					campos[linea][col].setBackground(Constants.COLOR_FONDO);
				}
			}
		}
		campos[0][0].setFont(Constants.FUENTE_NEGRITA);
		campos[0][0].setText(Constants.ENERGIA);
		
		campos[1][0].setText(Constants.POT_FACTURADA);
		campos[1][1].setText(potencia + " kW x " + dias + " días x " + kwEuros + " €/kW día");
		campos[1][2].setText(potenciaFac + Constants.EUR_SYMBOL);
		
		campos[2][0].setText(Constants.ENER_FACTURADA);
		campos[2][1].setText(kwh + " kWh x " + kwhEuros + " €/kWh");
		campos[2][2].setText(energiaFac + Constants.EUR_SYMBOL);
		
		campos[3][0].setText(Constants.IMP_ELECTRICIDAD);
		campos[3][1].setText(impuesto + "% s/" + (potenciaFac + energiaFac) + Constants.EUR_SYMBOL);
		campos[3][2].setText(impuestoFac + Constants.EUR_SYMBOL);
		
		campos[4][0].setText(Constants.TOT_ENERGIA);
		campos[4][2].setText(totalEnergia + Constants.EUR_SYMBOL);
		
		campos[6][0].setFont(Constants.FUENTE_NEGRITA);
		campos[6][0].setText(Constants.SERV_Y_OTROS);
		
		campos[7][0].setText(Constants.ALQ_EQUIPOS);
		campos[7][1].setText(dias+" días x " + equipos + " €/día");
		campos[7][2].setText(alquilerFac + Constants.EUR_SYMBOL);
		
		campos[8][0].setText(Constants.PROT_ELECTRICA);
		campos[8][1].setText( Utils.calcularMes(dias) + " mes x " + urgencias + " €/mes");
		campos[8][2].setText(urgenciasFac + Constants.EUR_SYMBOL);
		
		campos[9][0].setText(Constants.TOT_SERV_Y_OTROS);
		campos[9][2].setText(totalServicios + Constants.EUR_SYMBOL);
		
		campos[11][0].setText(Constants.IMPORTE_TOTAL);
		campos[11][2].setText(importeTotal + Constants.EUR_SYMBOL);
		
		campos[12][0].setText(Constants.IVA);
		campos[12][1].setText(iva + "% s/" + importeTotal + Constants.EUR_SYMBOL);
		campos[12][2].setText(ivaFac + Constants.EUR_SYMBOL);
		
		campos[13][0].setText(Constants.TOT_IMPORTE_FACT);
		campos[13][2].setText(res + Constants.EUR_SYMBOL);
		
		this.pack();
		this.setTitle(Constants.TITLE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		this.setVisible(true);
	}
}
