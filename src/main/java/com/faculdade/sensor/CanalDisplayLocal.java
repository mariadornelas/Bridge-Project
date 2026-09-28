package com.faculdade.sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Concrete Implementation: transmite a leitura para um painel/display
 * instalado fisicamente ao lado do equipamento monitorado.
 *
 * <p>Mantém um histórico das mensagens enviadas apenas para facilitar
 * a verificação em testes automatizados.</p>
 */
public class CanalDisplayLocal implements CanalComunicacao {

    private final List<String> mensagensEnviadas = new ArrayList<>();

    @Override
    public void enviar(String mensagem) {
        String formatada = "[DISPLAY LOCAL] " + mensagem;
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
