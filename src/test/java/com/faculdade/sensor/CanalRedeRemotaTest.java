package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanalRedeRemotaTest {

    private final CanalRedeRemota canal = new CanalRedeRemota();

    @Test
    void deveFormatarAMensagemComOPrefixoDaRede() {
        canal.enviar("teste");

        assertEquals(1, canal.getMensagensEnviadas().size());
        assertTrue(canal.getMensagensEnviadas().get(0).startsWith("[REDE REMOTA]"));
        assertTrue(canal.getMensagensEnviadas().get(0).contains("teste"));
    }

    @Test
    void deveAcumularVariasMensagensNoHistorico() {
        canal.enviar("primeira");
        canal.enviar("segunda");

        assertEquals(2, canal.getMensagensEnviadas().size());
    }
}
