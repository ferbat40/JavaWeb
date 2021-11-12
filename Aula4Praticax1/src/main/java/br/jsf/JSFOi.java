/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EjbOlaMundo;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFOi")
@RequestScoped
public class JSFOi {

    @EJB
    private EjbOlaMundo ejbOlaMundo;

    /**
     * Creates a new instance of JSFOi
     */
    public JSFOi() {
    }
    
    public String getOi(){
      return ejbOlaMundo.getOie();
    }
            
    
}
