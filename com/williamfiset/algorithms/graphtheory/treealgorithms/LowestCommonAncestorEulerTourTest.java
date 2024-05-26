package williamfiset.algorithms.graphtheory.treealgorithms;

import static com.google.common.truth.Truth.assertThat;
import static com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.addUndirectedEdge;
import static com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.createEmptyGraph;

import com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.TreeNode;
import java.util.*;
import org.junit.*;

public class LowestCommonAncestorEulerTourTest {

  private com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode createFirstTreeFromSlides() {
    int n = 17;
    List<List<Integer>> tree = com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.createEmptyGraph(n);

    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 0, 1);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 0, 2);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 1, 3);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 1, 4);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 5);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 6);

    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 7);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 3, 8);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 3, 9);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 5, 10);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 5, 11);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 7, 12);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 7, 13);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 14);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 15);
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 16);

    return com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode.rootTree(tree, 0);
  }

  @Test
  public void testLcaTreeFromSlides1() {
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode root = createFirstTreeFromSlides();
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour fastSolver = new com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour(root);
    assertThat(fastSolver.lca(14, 13).index()).isEqualTo(2);
    assertThat(fastSolver.lca(10, 16).index()).isEqualTo(5);
    assertThat(fastSolver.lca(9, 11).index()).isEqualTo(0);
  }

  @Test
  public void testLcaTreeFromSlides2() {
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode root = createFirstTreeFromSlides();
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour fastSolver = new com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour(root);
    assertThat(fastSolver.lca(8, 9).index()).isEqualTo(3);
    assertThat(fastSolver.lca(4, 8).index()).isEqualTo(1);
    assertThat(fastSolver.lca(6, 13).index()).isEqualTo(2);
    assertThat(fastSolver.lca(7, 13).index()).isEqualTo(7);
    assertThat(fastSolver.lca(10, 5).index()).isEqualTo(5);
    assertThat(fastSolver.lca(2, 16).index()).isEqualTo(2);
  }

  @Test
  public void testLcaOfTheSameNodeIsItself() {
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode root = createFirstTreeFromSlides();
    com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour fastSolver = new com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour(root);

    // Try all nodes
    for (int id = 0; id < root.size(); id++) {
      assertThat(fastSolver.lca(id, id).index()).isEqualTo(id);
    }
  }

  @Test
  public void randomizedLcaQueriesVsOtherImpl() {
    for (int n = 1; n < 1000; n++) {
      List<List<Integer>> g = generateRandomTree(n);

      com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.TreeNode root1 = com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.TreeNode.rootTree(g, 0);
      com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode root2 =
          com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode.rootTree(g, 0);

      com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor slowSolver = new com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor(root1);
      com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour fastSolver = new com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour(root2);

      for (int i = 0; i < 100; i++) {
        int l = (int) (Math.random() * n);
        int r = (int) (Math.random() * n);
        int L = Math.min(l, r);
        int R = Math.max(l, r);

        com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestor.TreeNode lca1 = slowSolver.lca(L, R);
        com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.TreeNode lca2 = fastSolver.lca(L, R);

        assertThat(lca1).isNotNull();
        assertThat(lca2).isNotNull();
        assertThat(lca1.id()).isEqualTo(lca2.index());
      }
    }
  }

  public static List<List<Integer>> generateRandomTree(int n) {
    List<Integer> nodes = new ArrayList<>();
    nodes.add(0);

    List<List<Integer>> g = com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.createEmptyGraph(n);
    for (int nextNode = 1; nodes.size() != n; nextNode++) {
      int randomNode = nodes.get((int) (Math.random() * nodes.size()));
      com.williamfiset.algorithms.graphtheory.treealgorithms.LowestCommonAncestorEulerTour.addUndirectedEdge(g, randomNode, nextNode);
      nodes.add(nextNode);
    }
    return g;
  }
}
