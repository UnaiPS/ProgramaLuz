package programaluz;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Constants {
    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    //Valores calculos
    public static final double KW_EUROS = 0.123009;
    public static final double KWH_EUROS = 0.203906;
    public static final double IMPUESTO = 5.1126932;
    public static final double EQUIPOS = 0.026557;
    public static final double URGENCIAS = 7.12;
    public static final double BONO_SOCIAL = 0.006282;
    public static final double IVA_21 = 21.0;
    public static final double MEDIA_MES = 30;
    public static final double CIEN = 100;

    //Otras constantes
    public static final String TIPO_FUENTE = "Verdana";
    public static final int TAMANO_FUENTE = 12;
    public static final Font FUENTE = new Font(Constants.TIPO_FUENTE, Font.PLAIN, Constants.TAMANO_FUENTE);
    public static final Font FUENTE_NEGRITA = new Font(Constants.TIPO_FUENTE, Font.BOLD, Constants.TAMANO_FUENTE);
    public static final Color COLOR = new Color(155, 128, 32);
    public static final Color COLOR_FONDO = new Color(222, 222, 255);
    public static final Border BORDE = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);

    //Textos aplicación
    public static final String KWH_CONSUMIDOS = "kWh consumidos:";
    public static final String KHW_CONSUMIDOS_TP = "Cantidad de kWh consumidos";
    public static final String NUM_DIAS = "Número de días:";
    public static final String NUM_DIAS_TP = "Número de días";
    public static final String KW_CONTRATADOS = "Potencia contratada (kW):";
    public static final String KW_CONTRATADOS_TP = "Potencia contratada (kW)";
    public static final String KW_PER_EURO = "Potencia (kw/€):";
    public static final String KW_PER_EURO_TP = "Potencia kw por euro (kw/€)";
    public static final String KWH_PER_EURO = "Energía (kwh/€):";
    public static final String KWH_PER_EURO_TP = "Potencia kwh por euro (kwh/€)";
    public static final String RESULT = "Resultado:";
    public static final String RESULT_TP = "Resultado";
    public static final String CALCULAR = "Calcular";
    public static final String CALCULAR_ACTION = "calcular";
    public static final String TITLE = "Calcular factura";
    public static final String ERROR = "Error.";
    public static final String ERROR_MSG = "Debes introducir los valores!";
    public static final String ENERGIA = "ENERGÍA";
    public static final String POT_FACTURADA = "Potencia facturada";
    public static final String ENER_CONSUMIDA = "Energía consumida";
    public static final String IMP_ELECTRICIDAD = "Impuesto sobre electricidad";
    public static final String TOT_ENERGIA = "TOTAL ENERGÍA";
    public static final String SERV_Y_OTROS = "SERVICIOS Y OTROS CONCEPTOS";
    public static final String ALQ_EQUIPOS = "Alquiler equipos medida";
    public static final String PROT_ELECTRICA = "Protección eléctrica hogar";
    public static final String TOT_SERV_Y_OTROS = "TOTAL SERVICIOS Y OTROS CONCEPTOS";
    public static final String IMPORTE_TOTAL = "IMPORTE TOTAL";
    public static final String IVA = "IVA";
    public static final String TOT_IMPORTE_FACT = "TOTAL IMPORTE FACTURA";
    public static final String FINAN_BONO_SOCIAL = "Financiación bono social fijo";
    public static final String KW_X = " kW x ";
    public static final String DIAS_X = " días x ";
    public static final String EUR_KW_DIA = " €/kW día";
    public static final String EUR_SYMBOL = " €";
    public static final String KWH_X = " kWh x ";
    public static final String EUR_KWH = " €/kWh";
    public static final String PERC_S = "% s/";
    public static final String EUR_DIA = " €/día";
    public static final String MES_X = " mes x ";
    public static final String EUR_MES = " €/mes";
}
