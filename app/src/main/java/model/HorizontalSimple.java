package model;

public class HorizontalSimple {
    /*Creacion de variables para los datos de entrada*/
    private double anguloTan;
    private double puntoInter;
    private double velocProy;
    private double gradoCurva;

    private double RC;

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
        String operaciones = "";



        return operaciones;
    }
}
