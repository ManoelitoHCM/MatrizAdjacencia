import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrizAdjacencia {

    private int qtdVertices;
    private String[] rotulos;
    private int[][] matrizAdjacencia;

    private boolean[] nosVisitados;

    public MatrizAdjacencia(int qtdVertices) {
        this.qtdVertices = qtdVertices;
        rotulos = new String[qtdVertices];
        matrizAdjacencia = new int[qtdVertices][qtdVertices];

        for (int linha = 0; linha < qtdVertices; linha++) {
            for (int coluna = 0; coluna < qtdVertices; coluna++) {
                matrizAdjacencia[linha][coluna] = 0;
            }
        }
    }

    public void inserirVertice(int no, String rotulo) {
        rotulos[no] = rotulo;
    }

    // no caso, o grafo é não direcionado e a matriz é espelhada
    public void inserirAresta(int noInicial, int noFinal) {
        if (noInicial != noFinal) {
            matrizAdjacencia[noInicial][noFinal] = 1;
            matrizAdjacencia[noFinal][noInicial] = 1;
        } else {
            matrizAdjacencia[noInicial][noFinal] = 2;
            matrizAdjacencia[noFinal][noInicial] = 2;
        }
    }

    public void exibirMatriz() {
        for (int linha = 0; linha < qtdVertices; linha++) {
            for (int coluna = 0; coluna < qtdVertices; coluna++) {
                System.out.print(matrizAdjacencia[linha][coluna] + " ");
            }
            System.out.println();
        }
    }

    // busca em profundidade usa recursão ou pilha em sua implementação
    public int DFS(String valor, int noInicial) {
        Stack<Integer> pilha = new Stack<>();
        nosVisitados = new boolean[qtdVertices];
        pilha.push(noInicial);

        while (!pilha.isEmpty()) {
            int noAtual = pilha.pop();
            nosVisitados[noAtual] = true;
            System.out.println(noAtual + " - valor: " + rotulos[noAtual]);

            if (rotulos[noAtual].equals(valor)) {
                return noAtual;
            }

            for (int i = 0; i < qtdVertices; i++) {
                if (matrizAdjacencia[noAtual][i] == 1 && !nosVisitados[i]) {
                    pilha.push(i);
                }
            }
        }
        return -1;
    }

    // busca em largura usa de fila na sua implementação
    public int BFS(String valor, int noInicial) {
        Queue<Integer> fila = new LinkedList<>();
        nosVisitados = new boolean[qtdVertices];

        if (rotulos[noInicial].equals(valor)) {
            return noInicial;
        }

        nosVisitados[noInicial] = true;
        fila.add(noInicial);

        while (!fila.isEmpty()) {
            int noAtual = fila.poll();
            System.out.println(noAtual + " - valor: " + rotulos[noAtual]);

            for (int i = 0; i < qtdVertices; i++) {
                if (matrizAdjacencia[noAtual][i] == 1 && !nosVisitados[i]) {
                    if (rotulos[i].equals(valor)) {
                        return i;
                    }
                    nosVisitados[i] = true;
                    fila.add(i);
                }
            }
        }
        return -1;
    }
}


