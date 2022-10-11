import java.util.List;

public class App {

    public static void main(String[] args) {


        //Criando os Nos representando as Cidades
        Cidade<String> cidadeOradea = new Cidade<>("Oradea");
        Cidade<String> cidadeZerind = new Cidade<>("Zerind");
        Cidade<String> cidadeArad = new Cidade<>("Arad");
        Cidade<String> cidadeTimisoara = new Cidade<>("Timisoara");
        Cidade<String> cidadeLugoj = new Cidade<>("Lugoj");
        Cidade<String> cidadeMehadia = new Cidade<>("Mehadia");
        Cidade<String> cidadeDobreta = new Cidade<>("Dobreta");
        Cidade<String> cidadeCraiova = new Cidade<>("Craiova");
        Cidade<String> cidadeSibiu = new Cidade<>("Sibiu");
        Cidade<String> cidadeRimnicuVilcea = new Cidade<>("Rimnicu Vilcea");
        Cidade<String> cidadePitesti = new Cidade<>("Pitesti");
        Cidade<String> cidadeFagaras = new Cidade<>("Fagaras");
        Cidade<String> cidadeBucharest = new Cidade<>("Bucharest");
        Cidade<String> cidadeGiurgiu = new Cidade<>("Giurgiu");
        Cidade<String> cidadeUrziceni = new Cidade<>("Urziceni");
        Cidade<String> cidadeHirsova = new Cidade<>("Hirsova");
        Cidade<String> cidadeEforie = new Cidade<>("Eforie");
        Cidade<String> cidadeVaslui = new Cidade<>("Vaslui");
        Cidade<String> cidadeLasi = new Cidade<>("Lasi");
        Cidade<String> cidadeNeamt = new Cidade<>("Neamt");



        //Especificando as ligacoes entre as cidade e suas distancias
        //Ordea
        cidadeOradea.addCidadeVisinha(cidadeZerind, 71);
        cidadeOradea.addCidadeVisinha(cidadeSibiu, 151);

        //Zerind
        cidadeZerind.addCidadeVisinha(cidadeOradea, 71);
        cidadeZerind.addCidadeVisinha(cidadeArad, 75);

        //Arad
        cidadeArad.addCidadeVisinha(cidadeZerind, 75);
        cidadeArad.addCidadeVisinha(cidadeSibiu, 140);
        cidadeArad.addCidadeVisinha(cidadeTimisoara, 118);

        //Sibiu
        cidadeSibiu.addCidadeVisinha(cidadeOradea, 151);
        cidadeSibiu.addCidadeVisinha(cidadeArad,140);
        cidadeSibiu.addCidadeVisinha(cidadeFagaras, 99);
        cidadeSibiu.addCidadeVisinha(cidadeRimnicuVilcea, 80);

        //Timisoara
        cidadeTimisoara.addCidadeVisinha(cidadeArad, 118);
        cidadeTimisoara.addCidadeVisinha(cidadeLugoj, 111);

        //Lugoj
        cidadeLugoj.addCidadeVisinha(cidadeTimisoara,111);
        cidadeLugoj.addCidadeVisinha(cidadeMehadia, 70);

        //Mehadia
        cidadeMehadia.addCidadeVisinha(cidadeLugoj, 70);
        cidadeMehadia.addCidadeVisinha(cidadeDobreta, 75);

        //Dobreta
        cidadeDobreta.addCidadeVisinha(cidadeMehadia, 75);
        cidadeDobreta.addCidadeVisinha(cidadeCraiova, 120);

        //Craiova
        cidadeCraiova.addCidadeVisinha(cidadeDobreta, 120);
        cidadeCraiova.addCidadeVisinha(cidadeRimnicuVilcea, 146);
        cidadeCraiova.addCidadeVisinha(cidadePitesti, 138);

        //Rimnicu Vilcea
        cidadeRimnicuVilcea.addCidadeVisinha(cidadeSibiu, 80);
        cidadeRimnicuVilcea.addCidadeVisinha(cidadePitesti, 97);
        cidadeRimnicuVilcea.addCidadeVisinha(cidadeCraiova,146);

        //Pitesti
        cidadePitesti.addCidadeVisinha(cidadeRimnicuVilcea, 97);
        cidadePitesti.addCidadeVisinha(cidadeCraiova, 138);
        cidadePitesti.addCidadeVisinha(cidadeBucharest, 101);

        //Fagaras
        cidadeFagaras.addCidadeVisinha(cidadeSibiu, 99);
        cidadeFagaras.addCidadeVisinha(cidadeBucharest, 211);

        //Bucharest
        cidadeBucharest.addCidadeVisinha(cidadeFagaras, 211);
        cidadeBucharest.addCidadeVisinha(cidadePitesti, 101);
        cidadeBucharest.addCidadeVisinha(cidadeGiurgiu, 90);
        cidadeBucharest.addCidadeVisinha(cidadeUrziceni, 85);

        //Giurgiu
        cidadeGiurgiu.addCidadeVisinha(cidadeBucharest, 90);

        //Urziceni
        cidadeUrziceni.addCidadeVisinha(cidadeBucharest, 85);
        cidadeUrziceni.addCidadeVisinha(cidadeHirsova, 98);
        cidadeUrziceni.addCidadeVisinha(cidadeVaslui, 142);

        //Hirsova
        cidadeHirsova.addCidadeVisinha(cidadeUrziceni, 98);
        cidadeHirsova.addCidadeVisinha(cidadeEforie, 86);

        //Eforie
        cidadeEforie.addCidadeVisinha(cidadeHirsova, 86);

        //Vaslui
        cidadeVaslui.addCidadeVisinha(cidadeUrziceni, 142);
        cidadeVaslui.addCidadeVisinha(cidadeLasi, 92);

        //Lasi
        cidadeLasi.addCidadeVisinha(cidadeVaslui, 142);
        cidadeLasi.addCidadeVisinha(cidadeNeamt, 87);

        //Neamt
        cidadeNeamt.addCidadeVisinha(cidadeLasi, 87);


        //Criando uma instancia do algoritimo que acha o caminho mais proximo entra uma cidade e outra
        ShortestPath<String> dijkstra = new ShortestPath<>();
        //Calculando os caminhos mais curtos da cidade de Arad e outras
        dijkstra.calculateShortestPath(cidadeArad);

        //Imprimindo o caminho mais curto entre Arad e Bucharest, no entanto
        // poderiamos adicionar mais cades na lista de impressao para ver qual
        // e o caminho mais curto de Arad para essas cidades
        System.out.println("O caminho mais curto entre Arad e Bucharest e: ");
        dijkstra.printPaths(List.of(cidadeBucharest));

        //Outro exemplo
        System.out.println("\nO caminho mais curto entre Arad e Neamnt e: ");
        dijkstra.printPaths(List.of(cidadeNeamt));

    }

}