package com.ada.Banco.domain.gateway;

import com.ada.Banco.domain.model.Conta;

import java.math.BigDecimal;

public interface ContaGateway {
    Conta buscarPorCpf(String cpf);
    Conta salvar(Conta conta);
    Conta realizarDeposito(Conta conta, BigDecimal quantia);
}
