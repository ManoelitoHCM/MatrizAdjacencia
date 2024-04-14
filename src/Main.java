import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrizAdjacencia matriz = new MatrizAdjacencia(7);

        matriz.inserirAresta(0, 1);
        matriz.inserirAresta(1, 2);
        matriz.inserirAresta(2, 3);
        matriz.inserirAresta(3, 4);
        matriz.inserirAresta(4, 0);
        matriz.inserirAresta(2, 4);
        matriz.inserirAresta(1, 5);
        matriz.inserirAresta(5, 6);

        matriz.inserirVertice(0, "RJ");
        matriz.inserirVertice(1, "CE");
        matriz.inserirVertice(2, "BA");
        matriz.inserirVertice(3, "AM");
        matriz.inserirVertice(4, "ES");
        matriz.inserirVertice(5, "SP");
        matriz.inserirVertice(6, "MG");

        matriz.exibirMatriz();

        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha o método de busca (BFS ou DFS):");
        String metodoBusca = scan.nextLine();

        System.out.println("Escolha o estado que deseja procurar: ");
        String valorBuscado = scan.nextLine();

        switch (metodoBusca.toUpperCase()) {
            case "BFS":
                System.out.println("Busca em largura:");
                int resultadoBFS = matriz.BFS("MG", 0);
                if (resultadoBFS != -1) {
                    System.out.println("O valor 'MG' foi encontrado no vértice " + resultadoBFS);
                } else {
                    System.out.println("O valor 'MG' não foi encontrado no grafo.");
                }
                break;
            case "DFS":
                System.out.println("Busca em profundidade:");
                int resultadoDFS = matriz.DFS("MG", 0);
                if (resultadoDFS != -1) {
                    System.out.println("O valor 'MG' foi encontrado no vértice " + resultadoDFS);
                } else {
                    System.out.println("O valor 'MG' não foi encontrado no grafo.");
                }
                break;
            default:
                System.out.println("Método de busca inválido. Escolha entre BFS ou DFS.");
        }

        scan.close();
    }
}