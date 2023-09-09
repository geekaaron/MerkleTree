# MerkleTree
The implementation of a simple Merkle Tree in Java



For data {"abc", "123", "def", "456", "ghi"}, the Merkle Tree is

```java
|--hash: b6024f76286ea347bf179b5ae82467d95963d5d2a955ae630af0351feebbdc63
|    |--hash: 0f490ec9c44e3ec6a647f36b34d55d5bf89d534fe14b16c062ad1ca056c6352b
|    |    |--hash: 06d66691ebe4cb88361a39ff8cb94631b2f8664adb8cf65cfe3c95fff8d40fdf
|    |    |    |--hash: ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad
|    |    |    |--hash: a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3
|    |    |--hash: 60937bee7e875ecdfc9b7a46b2d389dd30c4421bc2dcffb444b2e3b9db972991
|    |    |    |--hash: cb8379ac2098aa165029e3938a51da0bcecfc008fd6795f401178647f96c5b34
|    |    |    |--hash: b3a8e0e1f9ab1bfe3a36f231f676f78bb30a519d2b21e6c530c0eee8ebb4a5d0
|    |--hash: 50ae61e841fac4e8f9e40baf2ad36ec868922ea48368c18f9535e47db56dd7fb
|    |    |--hash: 50ae61e841fac4e8f9e40baf2ad36ec868922ea48368c18f9535e47db56dd7fb
|    |    |    |--hash: 50ae61e841fac4e8f9e40baf2ad36ec868922ea48368c18f9535e47db56dd7fb
```

