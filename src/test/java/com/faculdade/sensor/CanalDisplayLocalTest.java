package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanalDisplayLocalTest {

    private final CanalDisplayLocal canal = new CanalDisplayLocal();

    @Test
    void deveFormatarAMensagemComOPrefixoDoDisplay() {
        canal.enviar("teste");

        assertEquals(1, canal.getMensagensEnviadas().size());
        assertTrue(canal.getMensagensEnviadas().get(0).startsWith("[DISPLAY LOCAL]"));
        assertTrue(canal.getMensagensEnviadas().get(0).contains("teste"));
    }

    @Test
    void deveAcumularVariasMensagensNoHistorico() {
        canal.enviar("primeira");
        canal.enviar("segunda");

        assertEquals(2, canal.getMensagensEnviadas().size());
    }

    @Test
    void historicoRetornadoDeveSerSomenteLeitura() {
        canal.enviar("teste");
        assertThrows(UnsupportedOperationException.class,
                () -> canal.getMensagensEnviadas().add("outra"));
    }
}
