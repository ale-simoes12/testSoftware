package com.example;


import com.exception.*;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    protected Troco troco;
    

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
        this.troco = new Troco(valor);
       
    }

    public double inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;

        return saldo;


    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<PapelMoeda> getTroco() {
        return troco.getIterator(); 
    }

    
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
