package com.ifmo.ve.analyzer;

public class VectorTokenizer extends org.apache.lucene.analysis.Tokenizer {
    @Override
    public boolean incrementToken() {
        return false;
    }
}
