/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase Departamento para gestionar la información de los departamentos
 */
public class Departamento {
    private int id;
    private String nombre;
    private String ubicacion;
    private double presupuesto;
    private List<Empleado> empleados;
    
    // Constructor
    public Departamento(int id, String nombre, String ubicacion, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
        this.empleados = new ArrayList<>();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
    
    public boolean crearDepartamento() throws Exception {
        // Validación con manejo de excepciones
        if (this.nombre == null || this.nombre.trim().isEmpty()) {
            throw new Exception("El nombre del departamento no puede estar vacio");
        }
        System.out.println("Departamento creado: " + this.nombre);
        return true;
    }
    
    public boolean actualizarDepartamento() throws Exception {
        // Validación con manejo de excepciones
        if (this.id <= 0) {
            throw new Exception("ID de departamento no es valido");
        }
        System.out.println("Departamento actualizado: " + this.nombre);
        return true;
    }
    
    public boolean eliminarDepartamento() throws Exception {
        // Validación con manejo de excepciones
        if (this.id <= 0) {
            throw new Exception("ID de departamento no es valido");
        }
        
        // Verificar si hay empleados asignados antes de eliminar
        if (!this.empleados.isEmpty()) {
            throw new Exception("No se puede eliminar un departamento con empleados asignados");
        }
        System.out.println("Departamento eliminado: " + this.nombre);
        return true;
    }
    
    public boolean agregarEmpleado(Empleado empleado) throws Exception {
        // Validación con manejo de excepciones
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo");
        }
        
        // Verificar si el empleado ya está asignado a este departamento
        if (this.empleados.contains(empleado)) {
            throw new Exception("El empleado ya está asignado a este departamento");
        }
        
        // Actualizar la referencia del departamento en el empleado
        empleado.setDepartamento(this);
        
        // Agregar empleado a la lista
        this.empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " asignado al departamento " + this.nombre);
        return true;
    }
    
    public boolean eliminarEmpleado(Empleado empleado) throws Exception {
        // Validación con manejo de excepciones
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo");
        }
        
        // Verificar si el empleado pertenece a este departamento
        if (!this.empleados.contains(empleado)) {
            throw new Exception("El empleado no pertenece a este departamento");
        }
        
        // Eliminar la referencia del departamento en el empleado
        empleado.setDepartamento(null);
        
        // Eliminar empleado de la lista
        this.empleados.remove(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " removido del departamento " + this.nombre);
        return true;
    }
    
    public boolean asignarPresupuesto(double nuevoPresupuesto) throws Exception {
        // Validación con manejo de excepciones
        if (nuevoPresupuesto < 0) {
            throw new Exception("El presupuesto no puede ser negativo");
        }
        
        this.presupuesto = nuevoPresupuesto;
        System.out.println("Nuevo presupuesto asignado al departamento " + this.nombre + ": " + nuevoPresupuesto);
        return true;
    }
    
    @Override
    public String toString() {
        return "Departamento{" + 
               "id=" + id + 
               ", nombre='" + nombre + '\'' + 
               ", ubicacion='" + ubicacion + '\'' + 
               ", presupuesto=" + presupuesto + 
               ", empleados=" + empleados.size() + '}';
    }
}
