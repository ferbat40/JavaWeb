/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.lib.ICalculadora;
import javax.ejb.Stateless;

/**
 *
 * @author PARTICULAR
 */
@Stateless
public class EjbCalculadra implements br.lib.ICalculadora{

    @Override
    public int somar(int A, int B) {
 
        return A+B;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
