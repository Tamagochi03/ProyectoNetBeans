package logica;

import estados.*;
import estados.Estado;
import javax.media.j3d.TransformGroup;
import javax.swing.JLabel;
public class MaquinaTamagochi {

    Estado cansado;
    Estado hambriento;
    Estado durmiendo;
    Estado comiendo;
    Estado jugando;
    Estado muerto;
    Estado normal;
    MonitorDeEstados monitor;

    TransformGroup tg;
    JLabel mensaje;
    JLabel mensajeEstado; //TODO: delete

    int energia;
    int hambre;
    int sueno;
    int aburrimiento;
    
    Thread hiloMonitor;
    
    BarraEnergia hiloEneregia;
    BarraHambre hiloHambre;
    BarraSueno hiloSueno;
    BarraAburrimiento hiloAburrimiento;

    Estado estadoActual;

//TODO: delete Label estado del constructor
    public MaquinaTamagochi(TransformGroup tg, JLabel mensaje, JLabel estado){
        energia = 99;
        hambre = 1;
        sueno = 1;
        aburrimiento = 1;
        this.tg = tg;
        this.mensaje = mensaje;
        
        //Se instancían todos los estados
        
        cansado = new Cansado(this, this.mensaje);
        hambriento = new Hambriento(this, this.mensaje);
        durmiendo = new Durmiendo(this, this.mensaje);
        comiendo = new Comiendo(this, this.mensaje);
        jugando = new Jugando(this, this.mensaje);
        muerto = new Muerto(this, this.mensaje);
        normal = new Normal(this, this.mensaje);
        
        estadoActual = normal;
        
        //Se lazan los hilos que controlan las variables asociadas a las barras de progreso de la ventana.
        
        hiloEneregia = new BarraEnergia(energia, this);
        hiloHambre = new BarraHambre(hambre, this);
        hiloSueno = new BarraSueno(sueno, this);
        hiloAburrimiento = new BarraAburrimiento(aburrimiento, this);
        
        mensajeEstado = estado; //TODO: delete
        estado.setText(getNombreEstado()); //TODO:delete
        
        monitor = new MonitorDeEstados(this, this.mensajeEstado);
    }

    public void dormir() {
        estadoActual.dormir();
        mensajeEstado.setText(getNombreEstado()); //TODO: delete
    }

    public void comer() {
        estadoActual.comer();
        mensajeEstado.setText(getNombreEstado()); //TODO: delete
    }

    public void jugar() {
        estadoActual.jugar();
        mensajeEstado.setText(getNombreEstado()); //TODO: delete
    }

    void setState(Estado estado) {
        this.estadoActual = estado;
    }

    public Estado getCansado() {
        return cansado;
    }

    public Estado getHambriento() {
        return hambriento;
    }

    public Estado getDurmiendo() {
        return durmiendo;
    }

    public Estado getComiendo() {
        return comiendo;
    }

    public Estado getJugando() {
        return jugando;
    }

    public Estado getMuerto() {
        return muerto;
    }

    public Estado getNormal() {
        return normal;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public int getEnergia() {
        return energia;
    }

    public int getHambre() {
        return hambre;
    }

    public int getSueno() {
        return sueno;
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public void setSueno(int sueno) {
        this.sueno = sueno;
    }

    public void setAburrimiento(int aburrimiento) {
        this.aburrimiento = aburrimiento;
    }
    
    public TransformGroup getTg() {
        return tg;
    }

    public JLabel getMensaje() {
        return mensaje;
    }

    public BarraEnergia getHiloEneregia() {
        return hiloEneregia;
    }

    public BarraHambre getHiloHambre() {
        return hiloHambre;
    }

    public BarraSueno getHiloSueno() {
        return hiloSueno;
    }

    public BarraAburrimiento getHiloAburrimiento() {
        return hiloAburrimiento;
    }
    
    public void setTg(TransformGroup tg) {
        this.tg = tg;
    }

    public void setMensaje(JLabel mensaje) {
        this.mensaje = mensaje;
    }

    public void setEstado(Estado estado) {
            estadoActual = estado;
    }

    //Este metodo es auxiliar en el desarrollo para verificar la transicion de estados
    //TODO: delete
    public String getNombreEstado() {
        return estadoActual.getClass().getName();
    }

}
