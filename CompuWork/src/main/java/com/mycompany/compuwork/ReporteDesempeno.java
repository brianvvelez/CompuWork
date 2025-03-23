/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase ReporteDesempeno para reportes de desempeño
 */
public class ReporteDesempeno {
    private int id;
    private Date fecha;
    private double calificacion;
    private Empleado empleado;
    private String observaciones;
    private List<String> criteriosEvaluados;
    
    // Constructor para reporte individual
    public ReporteDesempeno(int id, Date fecha, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.empleado = empleado;
        this.calificacion = 0.0;
        this.observaciones = "";
        this.criteriosEvaluados = new ArrayList<>();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) throws Exception {
        // Validación con manejo de excepciones
        if (calificacion < 0 || calificacion > 10) {
            throw new Exception("La calificación debe estar entre 0 y 10");
        }
        this.calificacion = calificacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public List<String> getCriteriosEvaluados() {
        return new ArrayList<>(criteriosEvaluados);
    }
    
    public void agregarCriterio(String criterio) {
        this.criteriosEvaluados.add(criterio);
    }
    
    public void generarReporteIndividual() throws Exception {
        // Validación con manejo de excepciones
        if (this.empleado == null) {
            throw new Exception("No se puede generar un reporte sin un empleado asignado");
        }
        
        // Revisar como se van a generar los reportes, pero este nos sirve de muestra
        System.out.println("Generando reporte individual para: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Fecha: " + fecha);
        System.out.println("Calificacion: " + calificacion);
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Criterios evaluados:");
        for (String criterio : criteriosEvaluados) {
            System.out.println("- " + criterio);
        }
    }
    
    public static void generarReporteDpto(Departamento departamento) throws Exception {
        // Validación con manejo de excepciones
        if (departamento == null) {
            throw new Exception("No se puede generar un reporte sin un departamento");
        }
        
        // Obtener listado de empleados del departamento
        List<Empleado> empleados = departamento.getEmpleados();
        
        if (empleados.isEmpty()) {
            System.out.println("El departamento " + departamento.getNombre() + " no tiene empleados asignados");
            return;
        }
        System.out.println("=== REPORTE DEL DEPARTAMENTO: " + departamento.getNombre() + " ===");
        System.out.println("Ubicacion: " + departamento.getUbicacion());
        System.out.println("Presupuesto: " + departamento.getPresupuesto());
        System.out.println("Total de empleados: " + empleados.size());
        
        System.out.println("\nListado de empleados:");
        for (Empleado emp : empleados) {
            System.out.println("- " + emp.getNombre() + " " + emp.getApellido() + " - Salario: " + emp.calcularSalario());
        }
    }
    
    public double calcularPromedio() {
        return this.calificacion;
    }
    
    @Override
    public String toString() {
        return "ReporteDesempeno{" + 
               "id=" + id + 
               ", fecha=" + fecha + 
               ", calificacion=" + calificacion + 
               ", empleado=" + (empleado != null ? empleado.getNombre() + " " + empleado.getApellido() : "No asignado") + 
               ", observaciones='" + observaciones + '\'' + '}';
    }
}
