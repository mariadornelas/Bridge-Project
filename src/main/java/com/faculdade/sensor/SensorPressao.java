package com.faculdade.sensor;

/**
 * Refined Abstraction: sensor de pressão (em bar).
 *
 * <p>Herda de {@link Sensor} toda a lógica de transmissão via
 * {@link CanalComunicacao} e só precisa se preocupar com sua própria
 * regra de classificação.</p>
 */
public class SensorPressao extends Sensor {

    private static final double LIMITE_ALERTA = 8.0;
    private static final double LIMITE_CRITICO = 12.0;

    public SensorPressao(CanalComunicacao canal) {
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
        return "PRESSAO";
    }
}
