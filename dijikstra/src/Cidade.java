import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class Cidade<T> implements Comparable<Cidade<T>> {

    private final T Nome;
    private Integer distancia = Integer.MAX_VALUE;
    private List<Cidade<T>> shortestPath = new LinkedList<>();
    private Map<Cidade<T>, Integer> cidadesVisinhas = new HashMap<>();

    //adcicionar as cidades vizinhas de
    // uma cidade ou connectando as
    // cidades umas as outras
    public void addCidadeVisinha(Cidade<T> cidade, int distancia) {
        cidadesVisinhas.put(cidade, distancia);
    }

    //Comparar as cidades para ver qual e a mais proxima
    @Override
    public int compareTo(Cidade cidade) {
        return Integer.compare(this.distancia, cidade.getDistancia());
    }

}

