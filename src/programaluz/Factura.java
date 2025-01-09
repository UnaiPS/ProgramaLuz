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
		double ivaFac = urgenciasFac * Constants.IVA_21 / Constants.CIEN;
		double ivaReducido = (totalEnergia + alquilerFac) * Constants.IVA_10 / Constants.CIEN;
		res = importeTotal + ivaReducido + ivaFac;
		
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
				.iva21(Constants.IVA_21)
				.iva10(Constants.IVA_10)
				.kwh(kwh)
				.dias(dias)
				.potencia(potencia)
				.build();

		
		new MenuFinal(menuFinalDTO);
		return res;
	}
}
