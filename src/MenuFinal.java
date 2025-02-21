import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class MenuFinal extends JFrame {

    MenuFinal(double kwEuros, double kwhEuros, double impuesto, double equipos, double urgencias, double iva, int kwh, int dias, double potencia) {

		//potenciaFac
		double potenciaFac = potencia * dias * kwEuros * Constants.CIEN;
		potenciaFac = Utils.roundAndDivideByHundred(potenciaFac);

		//energiaFac
		double energiaFac = kwh*kwhEuros * Constants.CIEN;
		energiaFac = Utils.roundAndDivideByHundred(energiaFac);

		//bonoSocial
		double bonoSocial = dias * Constants.BONO_SOCIAL * Constants.CIEN;
		bonoSocial = Utils.roundAndDivideByHundred(bonoSocial);

		//impuestoFac
		double impuestoFac = Constants.CIEN * (potenciaFac + energiaFac) * impuesto / Constants.CIEN;
		impuestoFac = Utils.roundAndDivideByHundred(impuestoFac);

		//totalEnergia
		double totalEnergia = (potenciaFac + energiaFac + impuestoFac + bonoSocial) * Constants.CIEN;
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
		cp.setLayout(new GridLayout(15, 3));
        JTextField[][] campos = new JTextField[15][3];
		
		for(int linea=0; linea<15; linea++) {
			for(int col=0; col<3; col++) {
				campos[linea][col] = new JTextField();
				campos[linea][col].setFocusable(false);
				campos[linea][col].setEditable(false);
				campos[linea][col].setFont(Constants.FUENTE);
				campos[linea][col].setBackground(Color.WHITE);
				campos[linea][col].setBorder(null);
				cp.add(campos[linea][col]);
				if(col == 2) {
					campos[linea][col].setHorizontalAlignment(SwingConstants.RIGHT);
				}
				if(linea == 5 || linea == 10 || linea == 14) {
					campos[linea][col].setBorder(Constants.BORDE);
					campos[linea][col].setFont(Constants.FUENTE_NEGRITA);
					campos[linea][col].setForeground(Constants.COLOR);
				}
				if(linea == 12 || linea == 13 || linea == 14) {
					campos[linea][col].setBackground(Constants.COLOR_FONDO);
				}
			}
		}
		campos[0][0].setFont(Constants.FUENTE_NEGRITA);
		campos[0][0].setText(Constants.ENERGIA);
		
		campos[1][0].setText(Constants.POT_FACTURADA);
		campos[1][1].setText(potencia + Constants.KW_X + dias + Constants.DIAS_X + kwEuros + Constants.EUR_KW_DIA);
		campos[1][2].setText(potenciaFac + Constants.EUR_SYMBOL);
		
		campos[2][0].setText(Constants.ENER_CONSUMIDA);
		campos[2][1].setText(kwh + Constants.KWH_X + kwhEuros + Constants.EUR_KWH);
		campos[2][2].setText(energiaFac + Constants.EUR_SYMBOL);

		campos[3][0].setText(Constants.FINAN_BONO_SOCIAL);
		campos[3][1].setText(dias + Constants.DIAS_X + Constants.BONO_SOCIAL + Constants.EUR_DIA);
		campos[3][2].setText(bonoSocial + Constants.EUR_SYMBOL);
		
		campos[4][0].setText(Constants.IMP_ELECTRICIDAD);
		campos[4][1].setText(impuesto + Constants.PERC_S + (potenciaFac + energiaFac) + Constants.EUR_SYMBOL);
		campos[4][2].setText(impuestoFac + Constants.EUR_SYMBOL);
		
		campos[5][0].setText(Constants.TOT_ENERGIA);
		campos[5][2].setText(totalEnergia + Constants.EUR_SYMBOL);
		
		campos[7][0].setFont(Constants.FUENTE_NEGRITA);
		campos[7][0].setText(Constants.SERV_Y_OTROS);
		
		campos[8][0].setText(Constants.ALQ_EQUIPOS);
		campos[8][1].setText(dias + Constants.DIAS_X + equipos + Constants.EUR_DIA);
		campos[8][2].setText(alquilerFac + Constants.EUR_SYMBOL);
		
		campos[9][0].setText(Constants.PROT_ELECTRICA);
		campos[9][1].setText( Utils.calcularMes(dias) + Constants.MES_X + urgencias + Constants.EUR_MES);
		campos[9][2].setText(urgenciasFac + Constants.EUR_SYMBOL);
		
		campos[10][0].setText(Constants.TOT_SERV_Y_OTROS);
		campos[10][2].setText(totalServicios + Constants.EUR_SYMBOL);
		
		campos[12][0].setText(Constants.IMPORTE_TOTAL);
		campos[12][2].setText(importeTotal + Constants.EUR_SYMBOL);
		
		campos[13][0].setText(Constants.IVA);
		campos[13][1].setText(iva + Constants.PERC_S + importeTotal + Constants.EUR_SYMBOL);
		campos[13][2].setText(ivaFac + Constants.EUR_SYMBOL);
		
		campos[14][0].setText(Constants.TOT_IMPORTE_FACT);
		campos[14][2].setText(res + Constants.EUR_SYMBOL);
		
		this.pack();
		this.setTitle(Constants.TITLE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		this.setVisible(true);
	}
}
