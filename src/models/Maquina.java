package models;
import java.util.*;

public class Maquina {

    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;


    public Maquina(String nombre, String ip, int subred, int riesgo) {
        this.nombre = nombre;
        this.ip = ip;
        this.subred = subred;
        this.riesgo = riesgo;
        this.codigos = new ArrayList<>();
    }



    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = calcularSubred(ip);
        this.riesgo = calcularRiesgo(nombre, codigos);
    }
    



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.riesgo = calcularRiesgo(this.nombre, this.codigos);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
        this.subred = calcularSubred(this.ip);
    }

    public int getSubred() {
        return subred;
    }

    public void setSubred(int subred) {
        this.subred = subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
        this.riesgo = calcularRiesgo(this.nombre, this.codigos);
    }           

    private int calcularSubred(String ip) {
        String[] partes = ip.split("\\.");
        if (partes.length >= 3) {
            
            return Integer.parseInt(partes[2]);
        }else {
            return -1;
            
        }

    }

    private int calcularRiesgo(String nombre, List<Integer> codigos) {
        int suma = 0;
        for (int c : codigos) {
            if (c % 5 == 0) suma += c;
        }
        Set<Character> unicos = new HashSet<>();
        for (char ch : nombre.toCharArray()) {
            if (ch != ' ') unicos.add(ch);
        }
        return suma * unicos.size();
    }



    @Override
    public String toString() {
        return "Maquina :" + nombre + ", IP=" + ip + ", codigos=" + codigos + ", subred=" + subred + ", riesgo="
                + riesgo ;
    }

    

    
}
