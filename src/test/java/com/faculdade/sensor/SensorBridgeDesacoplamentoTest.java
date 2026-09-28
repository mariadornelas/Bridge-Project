package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorBridgeDesacoplamentoTest {

    @Test
    void qualquerTipoDeSensorDeveFuncionarComQualquerCanal() {
        CanalComunicacaoFake canal = new CanalComunicacaoFake();

        Sensor sensorTemperatura = new SensorTemperatura(canal);
        Sensor sensorPressao = new SensorPressao(canal);

        assertDoesNotThrow(() -> sensorTemperatura.monitorar(50.0));
        assertDoesNotThrow(() -> sensorPressao.monitorar(5.0));
        assertEquals(2, canal.getMensagensRecebidas().size());
    }

    @Test
    void oMesmoSensorDeveFuncionarComCanaisDiferentes() {
        CanalComunicacaoFake canalA = new CanalComunicacaoFake();
        CanalComunicacaoFake canalB = new CanalComunicacaoFake();

        Sensor sensor = new SensorTemperatura(canalA);
        sensor.monitorar(50.0);

        assertEquals(1, canalA.getMensagensRecebidas().size());
        assertEquals(0, canalB.getMensagensRecebidas().size());
    }

    @Test
    void deveSerPossivelTrocarOCanalEmTempoDeExecucaoSemRecriarOSensor() {
        CanalComunicacaoFake canalAntigo = new CanalComunicacaoFake();
        CanalComunicacaoFake canalNovo = new CanalComunicacaoFake();

        Sensor sensor = new SensorTemperatura(canalAntigo);
        sensor.monitorar(50.0);

        sensor.trocarCanal(canalNovo);
        sensor.monitorar(60.0);

        assertEquals(1, canalAntigo.getMensagensRecebidas().size());
        assertEquals(1, canalNovo.getMensagensRecebidas().size());
    }
}
