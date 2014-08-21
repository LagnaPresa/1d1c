package net.n39i.dsaa;

import java.util.Set;

public class Graph<V, E> {

    Set<Vertex<V>> vertexs;

    Set<Edge<E, V>> edges;

    public static class Vertex<V> {
        V item;
    }

    public static class UndirectedEdge<E, V> implements Edge<E, V>{
        E item;
        Vertex<V> v1;
        Vertex<V> v2;
    }
    
    public interface Edge<E, V> {
        
    }

}
