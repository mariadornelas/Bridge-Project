package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTemperaturaTest {

    private final CanalComunicacaoFake canal = new CanalComunicacaoFake();
    private final Sensor sensor = new SensorTemperatura(canal);

    @Test
    void deveClassificarComoNormalAbaixoDoLimiteDeAlerta() {
        assertEquals("NORMAL", sensor.monitorar(50.0));
    }

    @Test
    void deveClassificarComoAlertaEntreOsLimites() {
        assertEquals("ALERTA", sensor.monitorar(75.0));
    }

    @Test
    void deveClassificarComoCriticoAcimaDoLimiteCritico() {
        assertEquals("CRITICO", sensor.monitorar(95.0));
    }

    @Test
    void deveEnviarAMensagemPeloCanalConfigurado() {
        sensor.monitorar(50.0);

        assertEquals(1, canal.getMensagensRecebidas().size());
        assertTrue(canal.getMensagensRecebidas().get(0).contains("TEMPERATURA"));
        assertTrue(canal.getMensagensRecebidas().get(0).contains("NORMAL"));
    }
}
