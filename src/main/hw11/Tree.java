package hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tree<T> implements Search<T> {
    T node;
    private List<Tree<T>> children = new ArrayList<>();
    private Object Tree;

    public Tree(T node) {
        this.node = node;
    }

    public Tree() {
        this.node = null;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(Tree<T>... child) {
        this.children = List.of(child);
    }

    @Override
    public String toString() {
        return node.toString();
    }

    @Override
    public int hashCode() {
        return node.hashCode();
    }

    public void print(Tree<T> tree, String add) {
        System.out.println(add + " " + tree.node);
        for (Tree<T> children : tree.getChildren()) {
            print(children, add);
        }
    }

    private Tree<T> loadTree(List<T> list) {
        Tree<T> root = new Tree<T>();
        if (list.size() == 1) {
            return new Tree<T>(list.get(0));
        }
        if (list.size() == 2) {
            root.node = list.get(0);
            root.setChildren(new Tree<>(list.get(1)));
            return root;
        }

        root.node = list.get(list.size() / 2);
        root.setChildren(
                loadTree(list.subList(0, list.size() / 2)),
                loadTree(list.subList(list.size() / 2 + 1, list.size()))
        );

        return root;
    }

    public void loadList(T... list) {
        this.node = list[list.length / 2];
        this.setChildren(
                loadTree(List.of(list).subList(0, list.length / 2)),
                loadTree(List.of(list).subList(list.length / 2 + 1, list.length))
        );
    }

    private Tree<T> findInTree(Tree<T> tree, T findNumbers) {
        Tree<T> find;
        if (tree.node.equals(findNumbers)) {
            return tree;
        }
        for (Tree<T> children : tree.getChildren()) {
            find = findInTree(children, findNumbers);
            if (find != null) {
                return find;
            }
        }
        return null;
    }

    @Override
    public T find(T numbers) {
        Tree<T> findNumbers;
        findNumbers = findInTree(this, numbers);
        if (findNumbers != null) {
            return findNumbers.node;
        }
        return null;
    }

    private List<Tree<T>> toList(Tree<T> Tree) {
        List<Tree<T>> list = new ArrayList<>();

        list.add(Tree);
        for (Tree<T> children : Tree.getChildren()) {
            list.addAll(toList(children));
        }
        return list;
    }

    @Override
    public List getSortedList() {
        List<Tree<T>> list = toList(this);

        Set<T> set = new HashSet<>();

        for (Tree<T> mTree : list) {
            set.add(mTree.node);
        }

        return Arrays.asList(set.toArray());
    }
}