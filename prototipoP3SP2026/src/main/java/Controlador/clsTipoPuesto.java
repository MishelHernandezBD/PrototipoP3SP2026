//  creado por britany mishel Hernendez Davila 9959-24-4178

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Mishel
 */
public class clsTipoPuesto {
   //Atributos 
    private int idTipoPuesto;
    private String nombrePuesto; 
    private double salario;

    //Constructores
    public clsTipoPuesto() {
    }

    public clsTipoPuesto(int idTipoPuesto, String nombrePuesto, double salario) {
        this.idTipoPuesto = idTipoPuesto;
        this.nombrePuesto = nombrePuesto;
        this.salario = salario;
    }

    public clsTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public int getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "clsTipoPuesto{" + "idTipoPuesto=" + idTipoPuesto + ", nombrePuesto=" + nombrePuesto + ", salario=" + salario + '}';
    }
}
