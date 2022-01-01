package model;

public class Operaciones {



    public String convertirCadenamiento(double numero){
        double segundaParte = numero%1000;
        int primeraParte = (int) ( (numero - segundaParte)/1000);
        if ((segundaParte - (int)segundaParte)==0){
            return (primeraParte +" + "+ ((int)segundaParte));
        }else{
            return (primeraParte +" + "+ segundaParte);
        }
    }

    public double convertirADecimales(String grados){
        String arregloGrados[] = new String[3];
        String arrTemp []= grados.split("°");
        arregloGrados[0] = arrTemp[0].trim();
        arrTemp = arrTemp[1].split("'");
        arregloGrados[1] = arrTemp[0].trim();
        arrTemp = arrTemp[1].split("\"");
        arregloGrados[2]=arrTemp[0].trim();
        int g  = Integer.parseInt(arregloGrados[0]);
        double m  = Double.parseDouble(arregloGrados[1]);
        double s  = Double.parseDouble(arregloGrados[2]);
        double gradosDec = g+((m+(s/60))/60);
        return gradosDec;
    }

    public String convertirASeg(double grado){
        String resultado = "";
        double parteDecimal = grado % 1;
        double entero = grado-parteDecimal;
        int n = (int) entero;
        resultado += n+"° ";

        if (parteDecimal>0){
            grado = parteDecimal * 60;
            parteDecimal = grado % 1;
            entero = grado-parteDecimal;
            n=(int) entero;
            resultado += n +"' ";

            if (parteDecimal>0){
                grado = parteDecimal * 60;
                parteDecimal = grado % 1;
                entero = grado-parteDecimal;
                n=(int) entero;
                resultado += n+"\" ";
            }else{
                resultado += "0\"";
            }
        }else{
            resultado += "0' 0\"";
        }
        return resultado;
    }

}
