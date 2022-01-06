package model;

import java.text.DecimalFormat;

public class HorizontalSimple {
    /*Creacion de variables para los datos de entrada*/

    private String AT;
    private String GC;
    private double anguloTan;
    private double puntoInter;
    private double velocProy;
    private String PrC;
    private String PrT;

    private double gradoCurva;

    private double RC;
    private double ST;
    private double LC;
    private double CL;
    private double M;
    private double E;
    private double PC;
    private double PT;

    public String getGC() {
        return GC;
    }
    public void setGC(String gc){
        GC=gc;
    }

    /*GET DE AT PARA GMS*/
    public String getAT() {
        return AT;
    }
    /*SET DE AT PARA GMS*/
    public void setAT(String AT) {
        this.AT = AT;
    }

    /*GET de Angulo de las tangentes*/
    public Double getAnguloTan() { return anguloTan; }

    /*SET de Angulo de las tangentes*/
    public void setAnguloTan(Double anguloTan) { this.anguloTan = anguloTan; }

    /*GET de Punto de Inflexion*/
    public Double getPuntoInter() { return puntoInter; }

    /*SET de Punto de Inflexion*/
    public void setPuntoInter(Double puntoInter) { this.puntoInter = puntoInter; }

    /*GET de Velocidad del proyecto*/
    public Double getVelocProy() { return velocProy; }

    /*SET de Velocidad del proyecto*/
    public void setVelocProy(Double velocProy) { this.velocProy = velocProy; }

    /*GET de Grado de Curvatura*/
    public Double getGradoCurva() { return gradoCurva; }

    /*SET de Grado de Curvatura*/
    public void setGradoCurva(Double gradoCurva) { this.gradoCurva = gradoCurva; }

    public String calcularCurva(){
        String operaciones = "Curva Horizontal\n";
        Operaciones  obj = new Operaciones();
        gradoCurva = obj.convertirADecimales(GC);

        RC = 1145.92/gradoCurva;
        operaciones += "RC = 1145.92 / " + gradoCurva + "\n";

        anguloTan = obj.convertirADecimales(AT);
        ST = RC*Math.tan(Math.toRadians(anguloTan/2));
        operaciones += "ST = " + RC + " * tan( " + anguloTan + " / 2 )\n";

        LC = (20*anguloTan)/gradoCurva;
        operaciones += "LC = ( 20 * " + anguloTan + " ) / " + gradoCurva + "\n";

        CL = 2 * RC * (Math.sin(Math.toRadians(anguloTan/2)));
        operaciones += "CL = ( 2 * " + RC + " * sin( " + anguloTan + " / 2 )\n";

        M = RC * (1-Math.cos(Math.toRadians(anguloTan/2)));
        operaciones += "M = " + RC + " * ( 1 - cos( " + anguloTan + " / 2 ))\n";

        E = RC * ((1/(Math.cos(Math.toRadians(anguloTan/2))))-1);
        operaciones += "E = " + RC + " * (( 1 / ( cos( " + anguloTan + " / 2 ))) -1 )\n";

        PC = puntoInter - ST;
        PrC = obj.convertirCadenamiento(PC);
        operaciones += "PC = " + puntoInter + " - " + ST + "\n";

        PT = PC + LC;
        PrT = obj.convertirCadenamiento(PT);
        operaciones += "PT = " + PC + " + " + LC + "\n";
        DecimalFormat df = new DecimalFormat("###.##");
        operaciones += "\nAT = "+AT
                        + "\nGC = " +GC
                        + "\nPI = " + puntoInter
                        + "\nVP = " + velocProy + " km/h"
                        + "\nRC = " + df.format(RC) + " m"
                        + "\nST = " + df.format(ST) + " m"
                        + "\nLC = " + df.format(LC) + " m"
                        + "\nCL = " + df.format(CL) + " m"
                        + "\nM  = " + df.format(M) + " m"
                        + "\nE  = " + df.format(E) + " m"
                        + "\nPC = " + PrC
                        + "\nPT = " + PrT;
        return operaciones;
    }
}
