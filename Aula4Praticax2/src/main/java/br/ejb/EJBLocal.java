/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author PARTICULAR
 */
@Stateless
public class EJBLocal implements EJBLocalLocal {

    
    @Override
    public int Dobrar(int valor) {
       return valor=valor*2;
    }
    
}
