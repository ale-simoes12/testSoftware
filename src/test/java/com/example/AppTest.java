package com.example;

import com.exception.PapelMoedaInvalidaException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; // Importação correta para JUnit 5
import org.junit.jupiter.api.Test; // Importação correta para JUnit 5

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testInserirComQuantiaValida() throws PapelMoedaInvalidaException {
        int saldoInicial = 0;
        TicketMachine objeto = new TicketMachine(saldoInicial);

        // Defina o saldo inicial esperado
        assertEquals(saldoInicial, objeto.getSaldo());

        // Teste com quantia válida
        int quantiaValida = 50;  // Valor que deve estar no array papelMoeda
        objeto.inserir(quantiaValida);

        // Verifique se o saldo foi atualizado corretamente
        int saldoEsperado = saldoInicial + quantiaValida;

        System.err.println(saldoEsperado);
        System.out.println(objeto.getSaldo());
        assertEquals(saldoEsperado, objeto.getSaldo());
    }

    @Test
    public void testGetQuantidade() {
      
        PapelMoeda papelMoeda = new PapelMoeda(20, 15);
        int quantidade = papelMoeda.getQuantidade();
        assertEquals(15, quantidade);
    }



     
    @Test
    public void testInserirComQuantiaInvalida() { // Altere void para public void
        int saldoInicial = 0;
        TicketMachine objeto = new TicketMachine(saldoInicial);

        // Teste com quantia inválida
        int quantiaInvalida = 15;  

        // Verifique se o PapelMoedaInvalidaException é lançado
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            objeto.inserir(quantiaInvalida);
        });
    }



    








}
