package com.faculdade.sensor;

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
