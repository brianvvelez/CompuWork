/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork;

import java.util.Date;

/**
 * Clase EmpleadoFijo que extiende de Empleado para representar empleados con contrato a termino fijo
 */
public class EmpleadoFijo extends Empleado {
    // Atributos de EmpleadoFijo del diagrama de clases
    private double salarioBase;
    private String[] beneficios;
    private double bonoAnual;
    
    // Constructor
    public EmpleadoFijo(int id, String nombre, String apellido, String email, 
                        Date fechaContratacion, double salarioBase, String[] beneficios, double bonoAnual) {
        super(id, nombre, apellido, email, fechaContratacion);
        this.salarioBase = salarioBase;
        this.beneficios = beneficios;
        this.bonoAnual = bonoAnual;
    }
    
    // Constructor sobrecargado con departamento
    public EmpleadoFijo(int id, String nombre, String apellido, String email, 
                        Date fechaContratacion, Departamento departamento,
                        double salarioBase, String[] beneficios, double bonoAnual) {
        super(id, nombre, apellido, email, fechaContratacion, departamento);
        this.salarioBase = salarioBase;
        this.beneficios = beneficios;
        this.bonoAnual = bonoAnual;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String[] getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String[] beneficios) {
        this.beneficios = beneficios;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }
    
    @Override
    public double calcularSalario() {
        // Para un empleado fijo, el salario incluye su salario base más el bono anual dividido x 12 meses
        return salarioBase + (bonoAnual / 12);
    }
    
    public void agregarBeneficio(String beneficio) throws Exception {
        // Validación con manejo de excepciones
        if (beneficio == null || beneficio.trim().isEmpty()) {
            throw new Exception("El beneficio no puede estar vacio");
        }
        
        // Creamos un nuevo array con espacio para un beneficio adicional
        String[] nuevosBeneficios = new String[beneficios.length + 1];
        System.arraycopy(beneficios, 0, nuevosBeneficios, 0, beneficios.length);
        nuevosBeneficios[beneficios.length] = beneficio;
        
        this.beneficios = nuevosBeneficios;
        System.out.println("Beneficio agregado: " + beneficio);
    }
    
    public double calcularBono() {
        return this.bonoAnual;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" EmpleadoFijo{salarioBase=").append(salarioBase)
          .append(", bonoAnual=").append(bonoAnual)
          .append(", beneficios=[");
        
        for (int i = 0; i < beneficios.length; i++) {
            sb.append(beneficios[i]);
            if (i < beneficios.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        
        return sb.toString();
    }
}
