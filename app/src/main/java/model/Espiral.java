package model;

public class Espiral {

    /*Variables para los datos de entrada*/
    public double pi; /*Cadenamiento*/
    public String angTan; /*Total de la curva*/
    public int vp; /*Velocidad de Proyecto*/
    public String gc; /*Grado de curvatura*/
    public int le; /*Longitud de la curvatura espiral*/
    public int dc; /*Deflexion de cadenamiento*/

    /*Variables para las operaciones*/
    public double rc; /*Radio de la curva circular*/
    public double k; /*Parametro de la espiral*/
    public double oe; /*Deflexion de la espiral*/
    public double ac; /*Deflexion de la cirva circular*/
    public double xc; /*Coordenada Ec de la curva en x*/
    public double yc; /*Coordenada de Ec de la curva en y*/
    public double p; /*Coordenadas del pc de la curva*/
    public double pck; /*Coordenada del Pc de la curva*/
    public double te; /*Tangente de la espiral*/
    public double ec; /*Externa de la curva espiral*/
    public double tl; /*Tangente larga*/
    public double tc; /*Tangente corta*/
    public double cle; /*Cuerda Larga*/
    public double oc; /*Deflexion para ec*/
    public double lc; /*Longitud de la curva circular*/

    /*Calculo de progresivas o cadenamiento*/
    public double pte; /*Progresiva de Te*/
    public double pec; /*Progresiva de Ec*/
    public double pce; /*Progresiva de Ce*/
    public double pet; /*Progresiva de et*/

    /*Creacion de get y set de los datos de entrada*/
    /*get y set de AngTan*/
    public String getAngTan() { return angTan; }
    public void setAngTan(String angTan) { this.angTan = angTan; }
    /*get y set de pi*/
    public double getPi() { return pi; }
    public void setPi(double pi) { this.pi = pi; }
    /*get y set de Vp*/
    public int getVp() { return vp; }
    public void setVp(int vp) { this.vp = vp; }
    /*get y set de gc*/
    public String getGc() { return gc; }
    public void setGc(String gc) { this.gc = gc; }
    /*get y set de le*/
    public int getLe() { return le; }
    public void setLe(int le) { this.le = le; }
    /*get y set de dc*/
    public int getDc() { return dc; }
    public void setDc(int dc) { this.dc = dc; }

    public String operaciones(){
        String resultado = "Curva en Espiral\n";
        Operaciones obj1 = new Operaciones(); //Para convertir a decimal
        Operaciones obj2 = new Operaciones(); // Para convertirlo en G M S

        resultado += "Cadenamiento PI: " + pi +
                    "\nTotal de la curva: "+ angTan +
                    "\nVelocidad de proyecto: "+ vp + " km/h"+
                    "\nGrado de curvatura: "+ gc +
                    "\nLongitud de la curva espiral: " + le + " m";

        /*1 Operaciones Radio de curvatura (Rc)*/
        //Llamamos al metodo de la conversion a decimal
        double decimalGC = obj1.convertirADecimales(gc);
        rc=(1146/decimalGC);// obtenemos rc en decimal

        /*2 Operaciones Parametro de la espiral (e)*/
        double pk=(rc*le);
        k=Math.sqrt(pk);

        /*3 Operaciones Deflexion de la espiral(0e)*/
        oe = (90/3.1416)*(le/rc); // resultado de oe en decimal
        //llamamos el metodo de conversion
        String gradosOE = obj2.convertirASeg(oe);//Saca Grados minutos y segundos

        /*4 Operaciones Deflexion de la curva circular (Ac)*/
        //convertirlo a decimal angTan
        //Llamamos al metodo de la conversion a decimal
        double decimalAT = obj1.convertirADecimales(angTan);
        ac=(decimalAT-(2*oe)); //Resultado
        String decimalAc = obj1.convertirASeg(ac);

        /*5 Operaciones Coordenada de Gc de la curva en x (xc)*/
        double a=le*0.01;
        xc=(100-0.00305*Math.pow(oe,2))*a;

        /*6 Operaciones Coordenada de Gc de la curva en y (yc)*/
        yc=(le/0.01)*(0.582*oe-0.0000126)*Math.pow(oe,3);

        /*7 Operaciones Coordenadas del Pc de la curva (P)*/
        double a1=1-Math.cos(Math.toRadians(oe));
        p=(yc)-(rc*(a1));//resultado de p

        /*8 Operaciones Coordenadas del Pc de la curva (K)*/
        double b1=Math.sin(Math.toRadians(oe));
        pck=(xc)-(rc*(b1));//resultado de pck

        /*9 Operaciones Tangente de la espiral (ste)*/
        te=(pck)+(rc+p)*Math.tan(decimalAT/2);

        /*10 Operaciones Externa de la curva espiral (ec)*/
        ec=(rc+p)*Math.sin(decimalAT/2)-(rc);

        /*11 Operaciones Tagente larga (tl)*/
        tl=xc-(yc/Math.tan(oe));

        /*12 Operaciones Tangente corta (tc)*/
        tc=yc/Math.sin(oe);

        /*13 Operaciones Cuerda larga (Cle)*/
        cle=Math.sqrt(Math.pow(xc,2)+Math.pow(yc,2));

        /*14 Operaciones Deflexion para Gc (pe)*/
        oc=Math.tan(yc/xc);

        /*15 Operaciones longitud de la curva circular (lc)*/
        lc=(20*ac)/decimalGC;

        /*Calculo de progresivas o cadenamiento*/
        Operaciones convertir= new Operaciones();
        /*1 Operaciones Progresiva de (te)*/
        pte=(pi-te);
        String  pte1 = convertir.convertirCadenamiento(pte);

        /*2 Operaciones Progresiva  (ce)*/
        pec=(te+le);
        String  pec1 = convertir.convertirCadenamiento(pec);

        /*3 Operaciones ce*/
        pce=(pec+lc);
        String  pce1 = convertir.convertirCadenamiento(pce);

        /*4 Operaciones et*/
        pet=(pce+le);
        String  pet1 = convertir.convertirCadenamiento(pet);

        resultado += "\n1ª Radio de la curva circular: "+ rc + " m"
                            +"\n2ª Parametro de la espiral: " + k + " m"
                            +"\n3ª Deflexion de la espiral: " + gradosOE
                            +"\n4ª Deflexion de la curva circular: " + decimalAc +" m"
                            +"\n5ª Coordenada Ec de la curva en Xc : " + xc +" m"
                            +"\n6ª Coordenada de Ec de la curva Yc: " + yc +" m"
                            +"\n7ª Coordenadas del PC de la curva P: " + p +" m"
                            +"\n8ª Coordenadas del PC de la curva K: " + pck +" m"
                            +"\n9ª Tangente de la Espiral STE: " + te +" m"
                            +"\n10ª Externa de la curva espiral Ec: " + ec +" m"
                            +"\n11ª Tangente Larga TL: " + tl +" m"
                            +"\n12ª Tangente Corta TC: " + tc +" m"
                            +"\n13ª Cuerda Larga CLe: " + cle +" m"
                            +"\n14ª Deflexion para Ec: " + pec +" m"
                            +"\n15ª Longitud de la curva Circular: " + lc +" m"
                            +"\nCalculo de Cadenamientos"
                            +"\n1ª Progresica de TE: " + pte1 +" m"
                            +"\n2ª Progresica de EC: " + pec1 +" m"
                            +"\n3ª Progresica de CE: " + pce1 +" m"
                            +"\n4ª Progresica de ET: " + pet1 +" m";
        return resultado;
    }
}
