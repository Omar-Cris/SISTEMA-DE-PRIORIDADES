  public class Main {
        public static void main(String[] args) {
            Monticulo monticulo = new Monticulo();
    
            monticulo.insertar(3, "Proceso A");
            monticulo.insertar(1, "Proceso B");
            monticulo.insertar(2, "Proceso C");
            monticulo.insertar(5, "Proceso D");
            monticulo.insertar(4, "Proceso E");
    
            while (!monticulo.estaVacio()) {
                Nodo proceso = monticulo.eliminar();
                System.out.println("Ejecutando: " + proceso.proceso + " con prioridad " + proceso.prioridad);
            }
        }
    }
    