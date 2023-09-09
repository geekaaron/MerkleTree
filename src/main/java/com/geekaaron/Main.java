package com.geekaaron;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        List<String> contents = Arrays.asList("abc", "123", "def", "456", "ghi");
        MerkleTree merkleTree = new MerkleTree(contents);
        merkleTree.traverse();
    }
}
