package controllers;
import java.util.*;
import models.*;

public class MaquinaController {

    public MaquinaController(){

    }

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> resultado = new Stack<>();
        for (Maquina m : maquinas) {
            if (m.getSubred() > umbral) {
                resultado.push(m);
            }
        }
        return resultado;
    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        Set<Maquina> resultado = new TreeSet<>(
            (a, b) -> {
                if (a.getSubred() != b.getSubred())
                    return Integer.compare(b.getSubred(), a.getSubred()); 
                return a.getNombre().compareTo(b.getNombre());
            }
        );
        while (!pila.isEmpty()) {
            resultado.add(pila.pop());
        }
        return resultado;
    }

    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        Map<Integer, Queue<Maquina>> resultado = new TreeMap<>(); 
        for (Maquina m : maquinas) {
            int nivelRiesgo = m.getRiesgo();
            resultado.putIfAbsent(nivelRiesgo, new LinkedList<>());
            resultado.get(nivelRiesgo).add(m);
        }
        return resultado;
    }

    
    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {

        int maxCantidad = 0;
        int maxRiesgo = Integer.MIN_VALUE;
        Queue<Maquina> grupo = null;
        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()) {
            int cantidad = entry.getValue().size();
            int riesgo = entry.getKey();
            if (cantidad > maxCantidad || (cantidad == maxCantidad && riesgo > maxRiesgo)) {
                maxCantidad = cantidad;
            }
        }
        return new Stack<>();
        
        



    
}
}
