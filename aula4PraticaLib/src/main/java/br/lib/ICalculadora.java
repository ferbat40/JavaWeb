/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lib;

import javax.ejb.Remote;

/**
 *
 * @author PARTICULAR
 */

@Remote
public interface ICalculadora {
    public int somar(int A, int B);
}
