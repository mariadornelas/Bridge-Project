package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorPressaoTest {

    private final CanalComunicacaoFake canal = new CanalComunicacaoFake();
    private final Sensor sensor = new SensorPressao(canal);

    @Test
    void deveClassificarComoNormalAbaixoDoLimiteDeAlerta() {
        assertEquals("NORMAL", sensor.monitorar(5.0));
    }

    @Test
    void deveClassificarComoAlertaEntreOsLimites() {
        assertEquals("ALERTA", sensor.monitorar(9.0));
    }

    @Test
    void deveClassificarComoCriticoAcimaDoLimiteCritico() {
        assertEquals("CRITICO", sensor.monitorar(13.0));
    }

    @Test
    void deveEnviarAMensagemPeloCanalConfigurado() {
        sensor.monitorar(5.0);

        assertEquals(1, canal.getMensagensRecebidas().size());
        assertTrue(canal.getMensagensRecebidas().get(0).contains("PRESSAO"));
    }
}
