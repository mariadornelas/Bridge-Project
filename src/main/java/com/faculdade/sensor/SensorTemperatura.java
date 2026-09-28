package com.faculdade.sensor;

/**
 * Refined Abstraction: sensor de temperatura (em °C).
 *
 * <p>Herda de {@link Sensor} toda a lógica de transmissão via
 * {@link CanalComunicacao} e só precisa se preocupar com sua própria
 * regra de classificação.</p>
 */
public class SensorTemperatura extends Sensor {

    private static final double LIMITE_ALERTA = 70.0;
    private static final double LIMITE_CRITICO = 90.0;

    public SensorTemperatura(CanalComunicacao canal) {
        super(canal);
    }

    @Override
    protected String classificar(double valorMedido) {
        if (valorMedido >= LIMITE_CRITICO) {
            return "CRITICO";
        } else if (valorMedido >= LIMITE_ALERTA) {
            return "ALERTA";
        } else {
            return "NORMAL";
        }
    }

    @Override
    protected String getTipo() {
        return "TEMPERATURA";
    }
}
