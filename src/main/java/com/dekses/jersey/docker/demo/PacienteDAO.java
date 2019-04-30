/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dekses.jersey.docker.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author white
 */
public class PacienteDAO {
    private static final Map<String, Paciente> pMap = new HashMap<String, Paciente>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
        Paciente p1 = new Paciente("E01", "Santiago", "Romero","29/02/1990","calle falsa 123","7276382191","871273","privado");
        Paciente p2 = new Paciente("E02", "Andrés", "González","30/02/1990","calle falsa 234","7872347479","254245","privado");
        Paciente p3 = new Paciente("E03", "Arya", "Stark","31/02/1990","calle falsa 123","8823838992","789456","publica");
 
        pMap.put(p1.getId(), p1);
        pMap.put(p2.getId(), p2);
        pMap.put(p3.getId(), p3);
    }
 
    public static Paciente getPaciente(String pNo) {
        return pMap.get(pNo);
    }
 
    public static Paciente addPaciente(Paciente equ) {
        pMap.put(equ.getId(), equ);
        return equ;
    }
 
    public static Paciente updatePaciente(Paciente equ) {
        pMap.put(equ.getId(), equ);
        return equ;
    }
 
    public static void deletePaciente(String pNo) {
        pMap.remove(pNo);
    }
 
    public static List<Paciente> getAllPacientes() {
        Collection<Paciente> c = pMap.values();
        List<Paciente> list = new ArrayList<Paciente>();
        list.addAll(c);
        return list;
    }
     
    List<Paciente> list;
}
