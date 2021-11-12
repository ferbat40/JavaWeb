/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.lib.ICalculadora;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFCalculadora")
@RequestScoped
public class JSFCalculadora {

    @EJB
    private ICalculadora ejbCalculadra;

   

    /**
     * Creates a new instance of JSFCalculadora
     */
    public JSFCalculadora() {
    }
    
    public void somar(){
        resultado=ejbCalculadra.somar(valora, valorb);
    }
    
    @Setter @Getter
    private int valora;
    
    @Setter @Getter
    private int valorb;
    
    @Setter @Getter
    private int resultado;
    
    
    
}
