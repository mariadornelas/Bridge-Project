package com.faculdade.sensor;

/**
 * Classe cliente da demonstração.
 *
 * <p>Repare que qualquer combinação entre tipo de sensor e canal de
 * comunicação funciona sem precisar criar uma classe nova para cada
 * par — essa é a razão de ser do Bridge. Com 2 sensores e 2 canais,
 * já temos 4 combinações possíveis, todas a partir de apenas 4 classes
 * concretas (em vez das 4 classes "combinadas" que seriam necessárias
 * sem o padrão, e que cresceriam ainda mais rápido a cada novo sensor
 * ou canal adicionado).</p>
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=== Central de Monitoramento Industrial (Bridge) ===\n");

        CanalComunicacao display = new CanalDisplayLocal();
        CanalRedeRemota rede = new CanalRedeRemota();

        System.out.println("--- Sensor de Temperatura, via Display Local ---");
        Sensor sensorTemperatura = new SensorTemperatura(display);
        sensorTemperatura.monitorar(50.0);
        sensorTemperatura.monitorar(95.0);

        System.out.println("\n--- O MESMO sensor, agora trocando para Rede Remota em tempo de execução ---");
        sensorTemperatura.trocarCanal(rede);
        sensorTemperatura.monitorar(75.0);

        System.out.println("\n--- Sensor de Pressão, via Rede Remota ---");
        Sensor sensorPressao = new SensorPressao(rede);
        sensorPressao.monitorar(5.0);
        sensorPressao.monitorar(13.0);

        System.out.println("\n--- O MESMO canal (rede) sendo usado por dois tipos de sensor diferentes ---");
        System.out.println("Mensagens que passaram pela rede remota até agora: "
                + rede.getMensagensEnviadas().size());
    }
}
