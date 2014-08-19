package net.n39i.dsaa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BinaryTree<T> {

    T item;

    BinaryTree<T> left;

    BinaryTree<T> right;

    public static <T> BinaryTree<T> nodeOf(T item) {
        return new BinaryTree<>(item);
    }

    private BinaryTree(T item) {
        this(item, null, null);
    }

    public BinaryTree(T item, BinaryTree<T> left, BinaryTree<T> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public void forEach(Travasal travasal, Consumer<? super T> action) {
        travasal.forEach(Optional.of(this), action);
    }

    public List<T> asList(Travasal travasal) {
        List<T> list = new LinkedList<>();
        travasal.forEach(Optional.of(this), x -> list.add(x));
        return list;
    }

    public enum Travasal {

        PREORDER {
            @Override
            <T> void forEach(Optional<BinaryTree<T>> bt,
                    Consumer<? super T> action) {
                bt.ifPresent(x -> {
                    action.accept(x.item);
                    forEach(Optional.ofNullable(x.left), action);
                    forEach(Optional.ofNullable(x.right), action);
                });
            }
        },

        INORDER {
            @Override
            <T> void forEach(Optional<BinaryTree<T>> bt,
                    Consumer<? super T> action) {
                bt.ifPresent(x -> {
                    forEach(Optional.ofNullable(x.left), action);
                    action.accept(x.item);
                    forEach(Optional.ofNullable(x.right), action);
                });
            }
        },

        POSTORDER {
            @Override
            <T> void forEach(Optional<BinaryTree<T>> bt,
                    Consumer<? super T> action) {
                bt.ifPresent(x -> {
                    forEach(Optional.ofNullable(x.left), action);
                    forEach(Optional.ofNullable(x.right), action);
                    action.accept(x.item);
                });
            }
        },

        ;

        abstract <T> void forEach(Optional<BinaryTree<T>> bt,
                Consumer<? super T> action);

    }

}
