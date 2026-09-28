package com.faculdade.sensor;

import java.util.Objects;

/**
 * Abstraction do padrão Bridge.
 *
 * <p>Representa "o que" o sensor faz (medir e classificar uma
 * grandeza física), mantendo uma referência a um
 * {@link CanalComunicacao} — a "ponte" para "como" a leitura é
 * transmitida. A classe {@code Sensor} e suas subclasses nunca sabem
 * qual canal concreto está sendo usado; e os canais nunca sabem qual
 * tipo de sensor os está usando. As duas hierarquias variam de forma
 * totalmente independente.</p>
 */
public abstract class Sensor {

    protected CanalComunicacao canal;

    protected Sensor(CanalComunicacao canal) {
        this.canal = Objects.requireNonNull(canal, "canal não pode ser nulo");
    }

    /**
     * Realiza a leitura, classifica o valor medido e envia o resultado
     * pelo canal de comunicação configurado.
     *
     * @param valorMedido valor bruto medido pelo sensor
     * @return o status da leitura: "NORMAL", "ALERTA" ou "CRITICO"
     */
    public final String monitorar(double valorMedido) {
        String status = classificar(valorMedido);
        String mensagem = String.format("%s valor=%.1f status=%s", getTipo(), valorMedido, status);
        canal.enviar(mensagem);
        return status;
    }

    /**
     * Troca o canal de comunicação usado por este sensor em tempo de
     * execução — a "ponte" pode ser trocada sem recriar o sensor.
     *
     * @param novoCanal o novo canal a ser usado a partir de agora
     */
    public final void trocarCanal(CanalComunicacao novoCanal) {
        this.canal = Objects.requireNonNull(novoCanal, "canal não pode ser nulo");
    }

    /**
     * @param valorMedido valor bruto medido pelo sensor
     * @return o status da leitura, de acordo com a regra de negócio
     *         específica de cada tipo de sensor
     */
    protected abstract String classificar(double valorMedido);

    /**
     * @return um identificador textual do tipo de sensor (ex: "TEMPERATURA")
     */
    protected abstract String getTipo();
}
