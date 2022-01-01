package model;

public class Espiral {

    /*Variables para los datos de entrada*/
    public String angTan; /*Total de la curva*/
    public double pi; /*Cadenamiento*/
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

    /*Creacion de get y set para las operaciones */
    /*get y set de rc*/
    public double getRc() { return rc; }
    public void setRc(double rc) { this.rc = rc; }
    /*get y set de k*/
    public double getK() { return k; }
    public void setK(double k) { this.k = k; }
    /*get y set de oe*/
    public double getOe() { return oe; }
    public void setOe(double oe) { this.oe = oe; }
    /*get y set de ac*/
    public double getAc() { return ac; }
    public void setAc(double ac) { this.ac = ac; }
    /*get y set de xc*/
    public double getXc() { return xc; }
    public void setXc(double xc) { this.xc = xc; }
    /*get y set de yc*/
    public double getYc() { return yc; }
    public void setYc(double yc) { this.yc = yc; }
    /*get y set de p*/
    public double getP() { return p; }
    public void setP(double p) { this.p = p; }
    /*get y set de pck*/
    public double getPck() { return pck; }
    public void setPck(double pck) { this.pck = pck; }
    /*get y set de te*/
    public double getTe() { return te; }
    public void setTe(double te) { this.te = te; }
    /*get y set de ec*/
    public double getEc() { return ec; }
    public void setEc(double ec) { this.ec = ec; }
    /*get y set de tl*/
    public double getTl() { return tl; }
    public void setTl(double tl) { this.tl = tl; }
    /*get y set de tc*/
    public double getTc() { return tc; }
    public void setTc(double tc) { this.tc = tc; }
    /*get y set de cle*/
    public double getCle() { return cle; }
    public void setCle(double cle) { this.cle = cle; }
    /*get y set de oc*/
    public double getOc() { return oc; }
    public void setOc(double oc) { this.oc = oc; }
    /*get y set de lc*/
    public double getLc() { return lc; }
    public void setLc(double lc) { this.lc = lc; }

    /*Creacion de get y set de calculo de cadenamiento*/
    /*get y set de pte*/
    public double getPte() { return pte; }
    public void setPte(double pte) { this.pte = pte; }
    /*get y set de pec*/
    public double getPec() { return pec; }
    public void setPec(double pec) { this.pec = pec; }
    /*get y set de pce*/
    public double getPce() { return pce; }
    public void setPce(double pce) { this.pce = pce; }
    /*get y set de pet*/
    public double getPet() { return pet; }
    public void setPet(double pet) { this.pet = pet; }

    public String operaciones(){
        String resultado = "";

        /*1 Operaciones Radio de curvatura (Rc)*/
        //convertirlo a decimal gc
        //Usamos un objeto de la clase grados
        Operaciones obj1 = new Operaciones();
        //Llamamos al metodo de la conversion a decimal
        double decimalGC = obj1.convertirADecimales(gc);
        rc=(1146/decimalGC);// obtenemos rc en decimal

        /*2 Operaciones Parametro de la espiral (e)*/
        k=Math.sqrt(rc*le);

        /*3 Operaciones Deflexion de la espiral(0e)*/
        oe = (90/Math.PI)*(le/rc); // resultado de oe en decimal
        //genera el valor en decimal
        //convertirlo en G M S
        //Usamos un objeto de la clase Grados
        Operaciones obj2 = new Operaciones();
        //llamamos el metodo de conversion
        String gradosOE = obj2.convertirASeg(oe);//Saca Grados minutos y segundos

        /*4 Operaciones Deflexion de la curva circular (Ac)*/
        //convertirlo a decimal angTan
        //Llamamos al metodo de la conversion a decimal
        double decimalAT = obj1.convertirADecimales(angTan);
        ac=(decimalAT-(2*oe)); //Resultado

        /*5 Operaciones Coordenada de Gc de la curva en x (xc)*/
        xc=(le/100)*(100-0.00305)*(Math.pow(oe,2));

        /*6 Operaciones Coordenada de Gc de la curva en y (yc)*/
        yc=(le/100)*(0.582*oe)-0.0000126*(Math.pow(oe,3));

        /*7 Operaciones Coordenadas del Pc de la curva (P)*/
        double a=Math.toRadians(oe);//primero cambiar a radianes
        double b=Math.cos(a);//segundo sacar el resultado a coseno
        p=yc-(rc*(1-b));//resultado de p

        /*8 Operaciones Coordenadas del Pc de la curva (K)*/
        double b1=Math.sin(a);
         k=(xc)-(rc*(b1));

        /*9 Operaciones Tangente de la espiral (ste)*/
         te=(k)+(rc+p)*Math.tan(decimalAT/2);

        /*10 Operaciones Externa de la curva espiral (ec)*/
         ec=(rc+p)*Math.sin(decimalAT/2)-(rc);

        /*11 Operaciones Tagente larga (tl)*/
           tl=xc - yc/Math.tan(oc);

        /*12 Operaciones Tangente corta (tc)*/
        tc=xc - yc/Math.sin(oc);

        /*13 Operaciones Cuerda larga (Cle)*/
         cle=Math.sqrt(Math.pow(xc,2)+Math.pow(yc,2));

        /*14 Operaciones Deflexion para Gc (pe)*/
           pec=Math.tan(yc/xc);

        /*15 Operaciones longitud de la curva circular (lc)*/
         lc=(20*ac)/decimalGC;

        /*Calculo de progresivas o cadenamiento*/
        /*1 Operaciones Progresiva de (te)*/
        pte=(pi-te);
        /*2 Operaciones Progresiva  (ce)*/
        pec=(te+le);
        /*3 Operaciones ce*/
        pce=(pec+lc);
        /*4 Operaciones et*/
        pet=(pce+le);

        return resultado;
    }
}
