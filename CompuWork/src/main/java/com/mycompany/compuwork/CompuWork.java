/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.compuwork;

import java.util.Date;
/**
 *
 * Clase CompuWork que contiene el metodo main donde iremos agregando todos los metodos para testear
 */
public class CompuWork {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA COMPUWORK ===");
        
        try {
            // Crear departamentos
            System.out.println("\n----- Creando Departamentos -----");
            Departamento deptoTI = new Departamento(1, "Sistemas", "Piso 3", 50000.0);
            deptoTI.crearDepartamento();
            
            Departamento deptoGH = new Departamento(2, "Gestion Humana", "Piso 1", 30000.0);
            deptoGH.crearDepartamento();
            
            // Crear empleados fijos
            System.out.println("\n----- Creando Empleados Fijos -----");
            String[] beneficiosDesarrollador = {"Seguro medico", "Bono por proyectos", "Home Office"};
            EmpleadoFijo empFijo1 = new EmpleadoFijo(
                1, "Brayan", "Varelas", "brayan.varelas@compuwork.com", 
                new Date(), 2500.0, beneficiosDesarrollador, 5000.0
            );
            Empleado.crearEmpleado(empFijo1);
            
            String[] beneficiosGerente = {"Seguro medico", "Vehiculo de empresa", "Plan de pensiones"};
            EmpleadoFijo empFijo2 = new EmpleadoFijo(
                2, "Andres", "Velez", "andres.velez@compuwork.com", 
                new Date(), 3500.0, beneficiosGerente, 10000.0
            );
            Empleado.crearEmpleado(empFijo2);
            
            // Crear empleados temporales
            System.out.println("\n----- Creando Empleados Temporales -----");
            Date fechaFinContrato1 = new Date(System.currentTimeMillis() + (90L * 24 * 60 * 60 * 1000)); 
            EmpleadoTemporal empTemp1 = new EmpleadoTemporal(
                3, "Juan", "Perez", "juan.perez@compuwork.com", 
                new Date(), 15.0, fechaFinContrato1, 160
            );
            Empleado.crearEmpleado(empTemp1);
            
            Date fechaFinContrato2 = new Date(System.currentTimeMillis() + (180L * 24 * 60 * 60 * 1000)); // 180 días después
            EmpleadoTemporal empTemp2 = new EmpleadoTemporal(
                4, "Ana", "Lopez", "ana.lopez@compuwork.com", 
                new Date(), 12.5, fechaFinContrato2, 80
            );
            Empleado.crearEmpleado(empTemp2);
            
            // Asignar empleados a departamentos
            System.out.println("\n----- Asignando Empleados a Departamentos -----");
            deptoTI.agregarEmpleado(empFijo1);
            deptoTI.agregarEmpleado(empTemp1);
            deptoGH.agregarEmpleado(empFijo2);
            deptoGH.agregarEmpleado(empTemp2);
            
            // Mostrar información de los departamentos con sus empleados
            System.out.println("\n----- Informacion de Departamentos -----");
            System.out.println(deptoTI);
            System.out.println(deptoGH);
            
            // Calcular y mostrar salarios
            System.out.println("\n----- Calculo de Salarios -----");
            System.out.println(empFijo1.getNombre() + " " + empFijo1.getApellido() + ": $" + empFijo1.calcularSalario());
            System.out.println(empFijo2.getNombre() + " " + empFijo2.getApellido() + ": $" + empFijo2.calcularSalario());
            System.out.println(empTemp1.getNombre() + " " + empTemp1.getApellido() + ": $" + empTemp1.calcularSalario());
            System.out.println(empTemp2.getNombre() + " " + empTemp2.getApellido() + ": $" + empTemp2.calcularSalario());
            
            // Generar reportes de desempeño
            System.out.println("\n-----Reportes de Desempeno -----");
            // Reporte individual
            ReporteDesempeno reporteBrayan = new ReporteDesempeno(1, new Date(), empFijo1);
            reporteBrayan.setCalificacion(8.5);
            reporteBrayan.setObservaciones("Excelente desempeno en el proyecto. Cumplio con los plazos establecidos.");
            reporteBrayan.agregarCriterio("Calidad del codigo");
            reporteBrayan.agregarCriterio("Cumplimiento de metas");
            reporteBrayan.agregarCriterio("Trabajo en equipo");
            reporteBrayan.generarReporteIndividual();
            
            // Reporte departamental
            System.out.println("\n----- Generando Reportes por Departamento -----");
            ReporteDesempeno.generarReporteDpto(deptoTI);
            
            // Añadir beneficio a empleado fijo
            empFijo1.agregarBeneficio("Capacitaciones");
            
            // Extender contrato de empleado temporal
            Date nuevaFechaFin = new Date(fechaFinContrato1.getTime() + (60L * 24 * 60 * 60 * 1000)); // 60 dias adicionales
            empTemp1.extenderContrato(nuevaFechaFin);
            
            // Registrar horas para empleado temporal
            empTemp2.registrarHoras(40);
            
            // Actualizar un empleado
            empFijo1.setNombre("Juan Carlos");
            empFijo1.actualizarEmpleado();
            
            // Modificar presupuesto de un departamento
            deptoGH.asignarPresupuesto(35000.0);
            
        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
