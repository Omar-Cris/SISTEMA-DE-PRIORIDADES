import java.util.ArrayList;

class Monticulo {
    private ArrayList<Nodo> heap;

    public Monticulo() {
        heap = new ArrayList<>();
    }

    public void insertar(int prioridad, String proceso) {
        Nodo nuevoNodo = new Nodo(prioridad, proceso);
        heap.add(nuevoNodo);
        subir(heap.size() - 1);
    }

    public Nodo eliminar() {
        if (heap.size() == 0) return null;
        Nodo raiz = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        bajar(0);
        return raiz;
    }

    private void subir(int index) {
        while (index > 0) {
            int padreIndex = (index - 1) / 2;
            if (heap.get(index).prioridad >= heap.get(padreIndex).prioridad) break;
            // Intercambiar
            Nodo temp = heap.get(index);
            heap.set(index, heap.get(padreIndex));
            heap.set(padreIndex, temp);
            index = padreIndex;
        }
    }

    private void bajar(int index) {
        int tamaño = heap.size();
        while (index < tamaño) {
            int hijoIzquierdo = 2 * index + 1;
            int hijoDerecho = 2 * index + 2;
            int menor = index;

            if (hijoIzquierdo < tamaño && heap.get(hijoIzquierdo).prioridad < heap.get(menor).prioridad) {
                menor = hijoIzquierdo;
            }
            if (hijoDerecho < tamaño && heap.get(hijoDerecho).prioridad < heap.get(menor).prioridad) {
                menor = hijoDerecho;
            }
            if (menor == index) break;
            // Intercambiar
            Nodo temp = heap.get(index);
            heap.set(index, heap.get(menor));
            heap.set(menor, temp);
            index = menor;
        }
    }

    public boolean estaVacio() {
        return heap.size() == 0;
    }
}
