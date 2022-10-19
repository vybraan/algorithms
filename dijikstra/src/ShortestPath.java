import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestPath<T> {

    public void calculateShortestPath(Cidade<T> partida) {
        partida.setDistancia(0);
        Set<Cidade<T>> cidadesVisitadas = new HashSet<>();
        Queue<Cidade<T>> cidadesNaoVisitadas = new PriorityQueue<>(Collections.singleton(partida));
        while (!cidadesNaoVisitadas.isEmpty()) {
            Cidade<T> cidadeActual = cidadesNaoVisitadas.poll();
            cidadeActual.getCidadesVisinhas()
                    .entrySet().stream()
                    .filter(entry -> !cidadesVisitadas.contains(entry.getKey()))
                    .forEach(entry -> {
                        avaliarCaminhoEDistancia(entry.getKey(), entry.getValue(), cidadeActual);
                        cidadesNaoVisitadas.add(entry.getKey());
                    });
            cidadesVisitadas.add(cidadeActual);
        }
    }

    private void avaliarCaminhoEDistancia(Cidade<T> cidadeVisitada, Integer comprimentoDoCaminho, Cidade<T> cidadeDePartida) {
        Integer novaDistancia = cidadeDePartida.getDistancia() + comprimentoDoCaminho;
        if (novaDistancia < cidadeVisitada.getDistancia()) {
            cidadeVisitada.setDistancia(novaDistancia);
            cidadeVisitada.setShortestPath(Stream.concat(cidadeDePartida.getShortestPath().stream(), Stream.of(cidadeDePartida)).toList());
        }
    }

    public void printPaths(List<Cidade<T>> cidades) {
        cidades.forEach(cidade -> {
            String caminho = cidade.getShortestPath().stream()
                    .map(Cidade::getNome).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((caminho.isBlank()
                    ? "%s : %s".formatted(cidade.getNome(), cidade.getDistancia())
                    : "%s -> %s : %s".formatted(caminho, cidade.getNome(), cidade.getDistancia()))
            );
        });
    }

}