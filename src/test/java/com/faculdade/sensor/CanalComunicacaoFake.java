package com.faculdade.sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Canal de comunicação "fake" usado apenas nos testes: registra as
 * mensagens recebidas sem imprimir nada no console e sem qualquer
 * lógica adicional. Permite testar a lógica de classificação dos
 * sensores isoladamente da implementação real de transmissão.
 */
class CanalComunicacaoFake implements CanalComunicacao {

    private final List<String> mensagensRecebidas = new ArrayList<>();

    @Override
    public void enviar(String mensagem) {
        mensagensRecebidas.add(mensagem);
    }

    List<String> getMensagensRecebidas() {
        return Collections.unmodifiableList(mensagensRecebidas);
    }
}
