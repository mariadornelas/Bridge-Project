package com.faculdade.sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Concrete Implementation: transmite a leitura para a rede supervisória
 * remota da planta (ex: um sistema SCADA central), simulando o envio
 * de um pacote de dados.
 *
 * <p>Mantém um histórico das mensagens enviadas apenas para facilitar
 * a verificação em testes automatizados.</p>
 */
public class CanalRedeRemota implements CanalComunicacao {

    private final List<String> mensagensEnviadas = new ArrayList<>();

    @Override
    public void enviar(String mensagem) {
        String formatada = "[REDE REMOTA] pacote transmitido: " + mensagem;
        System.out.println(formatada);
        mensagensEnviadas.add(formatada);
    }

    /**
     * @return histórico somente-leitura das mensagens já enviadas por este canal
     */
    public List<String> getMensagensEnviadas() {
        return Collections.unmodifiableList(mensagensEnviadas);
    }
}
