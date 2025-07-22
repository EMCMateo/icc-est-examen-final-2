import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Map;
import java.util.Queue;
import controllers.MaquinaController;
import models.Maquina;

public class App {
    public static void main(String[] args) throws Exception {
        List<Maquina> maquinas = crearMaquinas();
        MaquinaController controller = new MaquinaController();
        Stack<Maquina> maquinasFiltradas = controller.filtrarPorSubred(maquinas, 100);
        System.out.println("Maquinas filtradas por subred:");
        for(Maquina m : maquinasFiltradas){
            System.out.println(m.toString());
        }
        
        Set<Maquina> maquinasOrdenadas = controller.ordenarPorSubred(maquinasFiltradas);
        System.out.println("Maquinas ordenadas por subred:");
        for(Maquina m : maquinasOrdenadas){
            System.out.println(m.toString());
        }
        System.out.println();
        Map<Integer, Queue<Maquina>> maquinasAgrupadas = controller.agruparPorRiesgo(maquinas);
        System.out.println("Maquinas agrupadas por nivel de riesgo:");
        for(Map.Entry<Integer, Queue<Maquina>> entry : maquinasAgrupadas.entrySet()){
            System.out.println("Nivel de riesgo " + entry.getKey().toString() + ": " + entry.getValue().toString());
        }
        System.out.println();
       
    }

    static List<Maquina> crearMaquinas() {

        List<Maquina> maquinas = Arrays.asList(
    new Maquina("Servidor1", "192.168.200.15", Arrays.asList(5, 10, 3)),        // subred: 200, riesgo: 120
    new Maquina("Servidor1", "10.0.200.88", Arrays.asList(10, 2)),              // subred: 200, riesgo: 120
    new Maquina("Alpha2", "192.168.100.8", Arrays.asList(25, 1, 3, 10)),        // subred: 100, riesgo: 210
    new Maquina("Beta22", "10.0.250.100", Arrays.asList(5, 5, 5)),              // subred: 250, riesgo: 75
    new Maquina("Beta22", "172.16.250.101", Arrays.asList(10, 5)),              // subred: 250, riesgo: 75
    new Maquina("Base de Datos 1", "10.0.50.99", Arrays.asList(5, 15, 20, 1)),  // subred: 50, riesgo: 320
    new Maquina("ControlBackupX9", "172.16.90.5", Arrays.asList(25, 5, 10)),    // subred: 90, riesgo: 560
    new Maquina("ControlBackupX9", "172.16.99.8", Arrays.asList(5, 10))         // subred: 99, riesgo: 240
);
        return maquinas;

    }
}
