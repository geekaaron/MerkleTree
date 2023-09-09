package com.geekaaron;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String data;
    private String hash;

    TreeNode() {

    }

    TreeNode(@NotNull String data) {
        this.data = data;
        this.hash = DigestUtils.sha256Hex(data.getBytes());
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
