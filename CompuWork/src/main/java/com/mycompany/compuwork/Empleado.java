/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork;

import java.util.Date;

/**
 * Clase base abstracta Empleado en la cual vamos a implementar 
 * las funcionalidades comunes para todos los empleados
 */
public abstract class Empleado {
    // Atributos encapsulados
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaContratacion;
    private Departamento departamento;
    
    // Constructor
    public Empleado(int id, String nombre, String apellido, String email, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
    }
    
    // Constructor sobrecargado con departamento
    public Empleado(int id, String nombre, String apellido, String email, Date fechaContratacion, Departamento departamento) {
        this(id, nombre, apellido, email, fechaContratacion);
        this.departamento = departamento;
    }
    
    // Encapsulamiento
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    // Métodos CRUD del diagrama de clases
    public static boolean crearEmpleado(Empleado empleado) throws Exception {
        // Validación con manejo de excepciones
        if (empleado == null) {
            throw new Exception("No se puede crear un empleado nulo");
        }
        System.out.println("Empleado creado: " + empleado.getNombre() + " " + empleado.getApellido());
        return true;
    }
    
    public boolean actualizarEmpleado() throws Exception {
        // Validación con manejo de excepciones
        if (this.id <= 0) {
            throw new Exception("ID de empleado no es valido");
        }
        System.out.println("Empleado actualizado: " + this.nombre + " " + this.apellido);
        return true;
    }
    
    public boolean eliminarEmpleado() throws Exception {
        // Validación con manejo de excepciones
        if (this.id <= 0) {
            throw new Exception("ID de empleado no es valido");
        }
        System.out.println("Empleado eliminado: " + this.nombre + " " + this.apellido);
        return true;
    }
    
    public static Empleado obtenerInformacion(int idEmpleado) throws Exception {
        // Validación con manejo de excepciones
        if (idEmpleado <= 0) {
            throw new Exception("ID de empleado no es valido");
        }
        System.out.println("Obteniendo información del empleado con ID: " + idEmpleado);
        return null; // Devolvería el empleado si existiera, de momento lo dejamos asi para la proxima actividad
    }
    
    // Método abstracto para calcular salario
    public abstract double calcularSalario();
    
    @Override
    public String toString() {
        return "Empleado{" + 
               "id=" + id + 
               ", nombre='" + nombre + '\'' + 
               ", apellido='" + apellido + '\'' + 
               ", email='" + email + '\'' + 
               ", fechaContratacion=" + fechaContratacion + '}';
    }
}
