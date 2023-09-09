package com.geekaaron;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private List<TreeNode> list;
    private TreeNode root;

    MerkleTree(List<String> contents) {
        createMerkleTree(contents);
    }

    private void createMerkleTree(List<String> contents) {
        if (contents == null || contents.isEmpty()) {
            return;
        }

        list = new ArrayList<>();

        List<TreeNode> leafList = createLeafList(contents);
        list.addAll(leafList);

        List<TreeNode> parents = createParentList(leafList);
        list.addAll(leafList);

        while (parents.size() > 1) {
            parents = createParentList(parents);
            list.addAll(parents);
        }

        root = parents.get(0);
    }

    private @NotNull List<TreeNode> createLeafList(List<String> contents) {
        List<TreeNode> leafList = new ArrayList<>();

        if (contents == null || contents.isEmpty()) {
            return leafList;
        }

        for (String content : contents) {
            leafList.add(new TreeNode(content));
        }

        return leafList;
    }

    private @NotNull List<TreeNode> createParentList(List<TreeNode> leafList) {
        List<TreeNode> parents = new ArrayList<>();

        if (leafList == null || leafList.isEmpty()) {
            return parents;
        }

        int length = leafList.size();
        for (int i = 0; i < length - 1; i += 2) {
            TreeNode parent = createParentNode(leafList.get(i), leafList.get(i + 1));
            parents.add(parent);
        }

        if (length % 2 != 0) {
            TreeNode parent = createParentNode(leafList.get(length - 1), null);
            parents.add(parent);
        }

        return parents;
    }

    private @NotNull TreeNode createParentNode(TreeNode left, TreeNode right) {
        TreeNode parent = new TreeNode();

        parent.setLeft(left);
        parent.setRight(right);

        String hash = left.getHash();
        if (right != null) {
            hash = DigestUtils.sha256Hex(left.getHash() + right.getHash());
        }

        parent.setData(hash);
        parent.setHash(hash);

        return parent;
    }

    public void traverse() {
        traverse(root, 0);
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("|");
            System.out.print("    ");
        }

        System.out.print("|");
        System.out.print("--");
        
        System.out.println("hash: " + node.getHash());

        if (node.getLeft() != null) {
            traverse(node.getLeft(), depth + 1);
        }

        if (node.getRight() != null) {
            traverse(node.getRight(), depth + 1);
        }
    }
}
