package com.ada.Banco.domain.usecase;

import com.ada.Banco.domain.gateway.ContaGateway;
import com.ada.Banco.domain.model.Conta;
import com.ada.Banco.dummy.ContaGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CriarNovaContaTest {
    @Test
    public void deveLançarExceptionCasoUsuarioJaPossuaUmaConta(){
        //Given
        ContaGateway contaGateway = new ContaGatewayDummyImpl();  //Responsavel por  criar uma conta falsa.
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);

        //When
        Conta conta = new Conta(12345L,0002L,3L, BigDecimal.ZERO,"Bruno", "123456789");

        //Then
        Assertions.assertThrows(Exception.class,
                ()-> criarNovaConta.execute(conta));

    }
@Test
    public void deveRetornarConta() throws Exception {
        //Given
        ContaGateway contaGateway = new ContaGatewayDummyImpl();  //Responsavel por  criar uma conta falsa.
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);

        Conta conta = new Conta(123456L,00020L,3L, BigDecimal.ZERO,"Ligia", "123");

        //When
        criarNovaConta.execute(conta);
        //Then
        Assertions.assertAll(
                ()-> Assertions.assertEquals("123", conta.getCpf()),
                ()-> Assertions.assertEquals("Ligia",conta.getTitular())
);
    }
    @Test
    public void deveRealizarDeposito() throws Exception {
        //Given
        ContaGateway contaGateway = new ContaGatewayDummyImpl();  //Responsavel por  criar uma conta falsa.
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(123456L,00020L,3L, BigDecimal.ZERO,"Ligia", "123");
        criarNovaConta.execute(conta);
        //When
        //contaGateway.realizarDeposito(conta,BigDecimal.TEN).getSaldo();

        //Then
        Assertions.assertEquals(BigDecimal.TEN,contaGateway.realizarDeposito(conta,BigDecimal.TEN).getSaldo());

    }
}
