/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBLocal;
import br.ejb.EJBLocalLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFLocal")
@RequestScoped
public class JSFLocal {

    @EJB
    private EJBLocalLocal eJBLocal;
    
    
  

    /**
     * Creates a new instance of JSFLocal
     */
    public JSFLocal() {
    }
    
    
    private int valor;
    private int resultado;

    
    public void dobraValor(){
        resultado=eJBLocal.Dobrar(valor);
    }
    
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
