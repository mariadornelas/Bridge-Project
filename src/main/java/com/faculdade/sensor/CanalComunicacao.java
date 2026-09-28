package com.faculdade.sensor;

/**
 * Implementor do padrão Bridge.
 *
 * <p>Define o contrato comum a todo canal de comunicação por onde um
 * sensor pode transmitir suas leituras. É essa interface que
 * "atravessa a ponte" entre a abstração (o sensor) e sua implementação
 * concreta (como a mensagem de fato é entregue).</p>
 */
public interface CanalComunicacao {

    /**
     * Envia uma mensagem através deste canal.
     *
     * @param mensagem o texto já formatado a ser transmitido
     */
    void enviar(String mensagem);
}
