package programaluz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuFinalDTO {
    double kwEuros;
    double kwhEuros;
    double impuesto;
    double equipos;
    double urgencias;
    double iva21;
    double iva10;
    int kwh;
    int dias;
    double potencia;
}
