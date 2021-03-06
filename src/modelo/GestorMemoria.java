package modelo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

/**
 *
 * @author Mauro Federico Lopez
 */
public class GestorMemoria extends Observable {

    private Integer tamañoMemoriaFisica;
    private Integer tiempoSeleccionParticion;
    private Integer tiempoCargaPromedio;
    private Integer tiempoLiberacionParticion;
    private Estrategia estrategiaSeleccionParticion;
    // Procesos ordenados por tiempo de arribo.
    private LinkedList<Proceso> procesosEsperando;
    private LinkedList<Proceso> procesosFinalizados;
    private Integer indiceFragmentacionExterna;
    private HashMap<Integer,Evento> eventos;
    private Reloj reloj;

    public GestorMemoria() {
        this.procesosEsperando = new LinkedList();
        this.procesosFinalizados = new LinkedList();
        this.eventos = new HashMap();
        this.reloj = new Reloj();
        this.indiceFragmentacionExterna = 0;
    }

    public Integer tiempoRetornoMedio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer tiempoRetornoTanda() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ordenarProcesosPorTiempoArribo(LinkedList<Proceso> lista) {
        Collections.sort(procesosEsperando, new TiempoArriboProcesoComparator());
    }

    private Boolean hayProcesosEsperando(Integer instante) {
        if(!procesosEsperando.isEmpty())
            return procesosEsperando.getFirst().getTiempoArribo() <= instante;
        else
            return false;
    }

    private Boolean hayProcesosEnCola() {
        return !procesosEsperando.isEmpty();
    }

    private Boolean hayProcesosEnMemoria() {
        return estrategiaSeleccionParticion.hayParticionesOcupadas();
    }

    private Boolean hayParticionesParaLiberar() {
        return estrategiaSeleccionParticion.hayParticionesParaLiberar(getReloj().obtenerInstante());
    }

    private void simularSeleccionParticion(String nombreProceso) {
        for(int i = 0; i < tiempoSeleccionParticion; i++) {
                String msg = "Seleccionando una particion para el proceso '" + nombreProceso + "'";
                crearNuevoEvento(msg);
                calcularFragmentacionExterna();
                getReloj().incrementarReloj();
            }
    }

    private void simularCargaDeProceso(String nombreProceso) {
        for(int i = 0; i < tiempoCargaPromedio; i++) {
            String msg = "Cargando el proceso '" + nombreProceso + "' en la particion seleccionada";
            crearNuevoEvento(msg);
            calcularFragmentacionExterna();
            getReloj().incrementarReloj();
        }
    }

    private void simularLiberacionDeParticion(String nombreProceso) {
        for(int i = 0; i < tiempoLiberacionParticion; i++) {
            crearNuevoEvento("Liberando la particion que ocupa el proceso '" + nombreProceso + "' e intentando compactar la memoria");
            calcularFragmentacionExterna();
            getReloj().incrementarReloj();
        }
    }

    private void crearNuevoEvento(String msg) {
        this.getEventos().put(getReloj().obtenerInstante(), new Evento(estrategiaSeleccionParticion.obtenerParticionesActuales(), msg));
    }

    private void calcularFragmentacionExterna() {
        if(hayProcesosEsperando(reloj.obtenerInstante()))
            this.indiceFragmentacionExterna += this.estrategiaSeleccionParticion.calcularIndiceFragmentacionExterna();
    }

    public void simular() {
        if(hayParticionesParaLiberar()) {
            LinkedList<Proceso> procesos = estrategiaSeleccionParticion.listarProcesosFinalizados(getReloj().obtenerInstante());
            while(!procesos.isEmpty()) {
                Proceso p = procesos.removeFirst();
                simularLiberacionDeParticion(p.getNombre());
                this.estrategiaSeleccionParticion.liberarParticion(p);
                p.setTiempoPartida(getReloj().obtenerInstante());
                this.getProcesosFinalizados().addLast(p);
            }
        }

        if(hayProcesosEsperando(getReloj().obtenerInstante())) {
            Proceso p = procesosEsperando.removeFirst();
            simularSeleccionParticion(p.getNombre());
            if(estrategiaSeleccionParticion.hayEspacioParaProceso(p.getMemoriaRequerida())) {
                simularCargaDeProceso(p.getNombre());
                estrategiaSeleccionParticion.asignarParticion(p,getReloj().obtenerInstante());
            }
            else {
                reloj.decrementarReloj();
                if(p.getMemoriaRequerida() <= tamañoMemoriaFisica) {
                    procesosEsperando.addFirst(p);
                    crearNuevoEvento("No se encontro espacio para cargar el proceso '" + p.getNombre() + "'");
                    calcularFragmentacionExterna();
                    reloj.incrementarReloj();
                }
                else {
                    crearNuevoEvento("La memoria requerida por el proceso '" + p.getNombre() +"' no es soportada");
                    calcularFragmentacionExterna();
                    procesosFinalizados.addLast(p);
                    reloj.incrementarReloj();
                }
            }
        }

        if(hayProcesosEsperando(reloj.obtenerInstante())){
            simular();
        }
        else
            if(hayProcesosEnMemoria()) {
                crearNuevoEvento("Esperando a que termine al menos un proceso");
                calcularFragmentacionExterna();
                reloj.incrementarReloj();
                simular();
            }
            else
                if(hayProcesosEnCola()) {
                    crearNuevoEvento("Esperando a que arriben procesos");
                    calcularFragmentacionExterna();
                    reloj.incrementarReloj();
                    simular();
                }
                else
                    if(!hayProcesosEnMemoria() && !hayProcesosEnCola()) {
                        crearNuevoEvento("Fin de la simulación");
                    }
    }

    /**
     * @return the tamañoMemoriaFisica
     */
    public Integer getTamañoMemoriaFisica() {
        return tamañoMemoriaFisica;
    }

    /**
     * @param tamañoMemoriaFisica the tamañoMemoriaFisica to set
     */
    public void setTamañoMemoriaFisica(Integer tamañoMemoriaFisica) {
        this.tamañoMemoriaFisica = tamañoMemoriaFisica;
    }

    /**
     * @return the tiempoSeleccionParticion
     */
    public Integer getTiempoSeleccionParticion() {
        return tiempoSeleccionParticion;
    }

    /**
     * @param tiempoSeleccionParticion the tiempoSeleccionParticion to set
     */
    public void setTiempoSeleccionParticion(Integer tiempoSeleccionParticion) {
        this.tiempoSeleccionParticion = tiempoSeleccionParticion;
    }

    /**
     * @return the tiempoCargaPromedio
     */
    public Integer getTiempoCargaPromedio() {
        return tiempoCargaPromedio;
    }

    /**
     * @param tiempoCargaPromedio the tiempoCargaPromedio to set
     */
    public void setTiempoCargaPromedio(Integer tiempoCargaPromedio) {
        this.tiempoCargaPromedio = tiempoCargaPromedio;
    }

    /**
     * @return the tiempoLiberacionParticion
     */
    public Integer getTiempoLiberacionParticion() {
        return tiempoLiberacionParticion;
    }

    /**
     * @param tiempoLiberacionParticion the tiempoLiberacionParticion to set
     */
    public void setTiempoLiberacionParticion(Integer tiempoLiberacionParticion) {
        this.tiempoLiberacionParticion = tiempoLiberacionParticion;
    }

    /**
     * @return the estrategiaSeleccionParticion
     */
    public Estrategia getEstrategiaSeleccionParticion() {
        return estrategiaSeleccionParticion;
    }

    /**
     * @param estrategiaSeleccionParticion the estrategiaSeleccionParticion to set
     */
    public void setEstrategiaSeleccionParticion(Estrategia estrategiaSeleccionParticion) {
        this.estrategiaSeleccionParticion = estrategiaSeleccionParticion;
    }

    /**
     * @return the procesos
     */
    public LinkedList<Proceso> getProcesosEsperando() {
        return procesosEsperando;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesosEsperando(LinkedList<Proceso> procesosEsperando) {
        this.setProcesosEsperando(procesosEsperando);
    }

    /**
     * @return the indiceFragmentacionExterna
     */
    public Integer getIndiceFragmentacionExterna() {
        return indiceFragmentacionExterna;
    }

    /**
     * @param indiceFragmentacionExterna the indiceFragmentacionExterna to set
     */
    public void setIndiceFragmentacionExterna(Integer indiceFragmentacionExterna) {
        this.indiceFragmentacionExterna = indiceFragmentacionExterna;
    }

    /**
     * @return the procesosFinalizados
     */
    public LinkedList<Proceso> getProcesosFinalizados() {
        return procesosFinalizados;
    }

    /**
     * @param procesosFinalizados the procesosFinalizados to set
     */
    public void setProcesosFinalizados(LinkedList<Proceso> procesosFinalizados) {
        this.procesosFinalizados = procesosFinalizados;
    }

    /**
     * @return the eventos
     */
    public HashMap<Integer,Evento> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(HashMap<Integer,Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * @return the reloj
     */
    public Reloj getReloj() {
        return reloj;
    }

    /**
     * @param reloj the reloj to set
     */
    public void setReloj(Reloj reloj) {
        this.reloj = reloj;
    }

    public void notificarCambio() {
        setChanged();
        notifyObservers();
    }

}
