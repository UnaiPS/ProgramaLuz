

public class Factura {

	
	public static double calcular(int kwh, int dias, double potencia, double kwEuros, double kwhEuros) {
		double res;

		double potenciaFac = potencia * dias * kwEuros;
		double energiaFac = kwh * kwhEuros;
		double impuestoFac = (potenciaFac + energiaFac) * Constants.IMPUESTO / Constants.CIEN;
		double totalEnergia = potenciaFac + energiaFac + impuestoFac;

		double meses = Utils.calcularMes(dias);
		
		double alquilerFac = dias * Constants.EQUIPOS;
		double urgenciasFac = meses * Constants.URGENCIAS;
		double totalServicios = alquilerFac + urgenciasFac;
		
		double importeTotal = totalEnergia + totalServicios;
		double ivaFac = importeTotal * Constants.IVA_21 / Constants.CIEN;
		res = importeTotal + ivaFac;
		
		res = res * Constants.CIEN;
		double tmp = Math.round(res);
		res = tmp / Constants.CIEN;
		
		new MenuFinal(kwEuros, kwhEuros, Constants.IMPUESTO, Constants.EQUIPOS, Constants.URGENCIAS, Constants.IVA_21, kwh, dias, potencia);
		return res;
	}
}
