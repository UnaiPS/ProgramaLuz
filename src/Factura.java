

public class Factura {

	
	public static double calcular(int kwh, int dias, double potencia, double kwEuros, double kwhEuros) {
		double res = 0.0;

		double potenciaFac = potencia * dias * kwEuros;
		double energiaFac = kwh * kwhEuros;
		double impuestoFac = (potenciaFac + energiaFac) * Constants.impuesto / 100;
		double totalEnergia = potenciaFac + energiaFac + impuestoFac;
		
		double alquilerFac = dias * Constants.equipos;
		double urgenciasFac = ((double) dias / 30) * Constants.urgencias;
		double totalServicios = alquilerFac + urgenciasFac;
		
		double importeTotal = totalEnergia + totalServicios;
		double ivaFac = importeTotal * Constants.iva / 100;
		res = importeTotal + ivaFac;
		
		res = res * 100;
		long tmp = Math.round(res);
		res = (double) tmp / 100;
		
		new MenuFinal(kwEuros, kwhEuros, Constants.impuesto, Constants.equipos, Constants.urgencias, Constants.iva, kwh, dias, potencia);
		return res;
	}
}
