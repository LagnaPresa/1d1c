package net.n39i.dsaa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import net.n39i.dsaa.BinaryTree.Travasal;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    private BinaryTree<Integer> tree;

    // _____1___
    // ____/_\__
    // ___2___3_
    // __/_\____
    // _4___5___
    @Before
    public void setUp() throws Exception {
        tree = BinaryTree.nodeOf(1);
        tree.left = BinaryTree.nodeOf(2);
        tree.right = BinaryTree.nodeOf(3);

        tree.left.left = BinaryTree.nodeOf(4);
        tree.left.right = BinaryTree.nodeOf(5);
    }

    @Test
    public void test() {
        assertThat(tree.asList(Travasal.PREORDER),
                is(Arrays.asList(1, 2, 4, 5, 3)));

        assertThat(tree.asList(Travasal.INORDER),
                is(Arrays.asList(4, 2, 5, 1, 3)));

        assertThat(tree.asList(Travasal.POSTORDER),
                is(Arrays.asList(4, 5, 2, 3, 1)));
    }

}
