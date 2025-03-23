/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork;

import java.util.Date;

/**
 * Clase EmpleadoTemporal que extiende de Empleado para representar empleados con contrato temporal
 */
public class EmpleadoTemporal extends Empleado {
    private double tarifaHora;
    private Date fechaFinContrato;
    private int horasTrabajadas;
    
    // Constructor
    public EmpleadoTemporal(int id, String nombre, String apellido, String email, 
                           Date fechaContratacion, double tarifaHora, 
                           Date fechaFinContrato, int horasTrabajadas) {
        super(id, nombre, apellido, email, fechaContratacion);
        this.tarifaHora = tarifaHora;
        this.fechaFinContrato = fechaFinContrato;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    // Constructor sobrecargado con departamento
    public EmpleadoTemporal(int id, String nombre, String apellido, String email, 
                           Date fechaContratacion, Departamento departamento,
                           double tarifaHora, Date fechaFinContrato, int horasTrabajadas) {
        super(id, nombre, apellido, email, fechaContratacion, departamento);
        this.tarifaHora = tarifaHora;
        this.fechaFinContrato = fechaFinContrato;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    // Getters y Setters
    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    @Override
    public double calcularSalario() {
        // Para un empleado temporal, su salario se calcula con las horas trabajadas porel valor por hora
        return tarifaHora * horasTrabajadas;
    }
    
    public boolean extenderContrato(Date nuevaFechaFin) throws Exception {
        // Validación con manejo de excepciones
        if (nuevaFechaFin == null || nuevaFechaFin.before(new Date())) {
            throw new Exception("La nueva fecha de fin debe ser valida y posterior a la fecha actual");
        }
        
        // Verificamos que la nueva fecha sea posterior a la fecha de fin actual
        if (nuevaFechaFin.before(this.fechaFinContrato)) {
            throw new Exception("La nueva fecha de fin debe ser posterior a la fecha de fin actual");
        }
        
        this.fechaFinContrato = nuevaFechaFin;
        System.out.println("Contrato extendido hasta: " + nuevaFechaFin);
        return true;
    }
    
    public void registrarHoras(int horas) throws Exception {
        // Validación con manejo de excepciones
        if (horas <= 0) {
            throw new Exception("Las horas registradas deben ser mayores a cero");
        }
        
        this.horasTrabajadas += horas;
        System.out.println("Horas registradas: " + horas + ". Total: " + this.horasTrabajadas);
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               " EmpleadoTemporal{tarifaHora=" + tarifaHora + 
               ", fechaFinContrato=" + fechaFinContrato + 
               ", horasTrabajadas=" + horasTrabajadas + '}';
    }
}
