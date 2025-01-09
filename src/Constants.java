import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Constants {
    //Valores calculos
    public static final double KW_EUROS = 0.123009;
    public static final double KWH_EUROS = 0.203906;
    public static final double IMPUESTO = 5.1126932;
    public static final double EQUIPOS = 0.026557;
    public static final double URGENCIAS = 7.12;
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

}
