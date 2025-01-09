package programaluz;

import programaluz.dto.MenuFinalDTO;

class Factura {

	private Factura(){
		throw new IllegalStateException("Factura class");
	}

	
	public static double calcular(int kwh, int dias, double potencia, double kwEuros, double kwhEuros) {
		double res;

		double potenciaFac = potencia * dias * kwEuros;
		double energiaFac = kwh * kwhEuros;
		double bonoSocial = dias * Constants.BONO_SOCIAL;
		double impuestoFac = (potenciaFac + energiaFac) * Constants.IMPUESTO / Constants.CIEN;
		double totalEnergia = potenciaFac + energiaFac + bonoSocial + impuestoFac;

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

		MenuFinalDTO menuFinalDTO = MenuFinalDTO
				.builder()
				.kwEuros(kwEuros)
				.kwhEuros(kwhEuros)
				.impuesto(Constants.IMPUESTO)
				.equipos(Constants.EQUIPOS)
				.urgencias(Constants.URGENCIAS)
				.iva(Constants.IVA_21)
				.kwh(kwh)
				.dias(dias)
				.potencia(potencia)
				.build();

		
		new MenuFinal(menuFinalDTO);
		return res;
	}
}
