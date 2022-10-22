package com.ifmo.ve.analyzer;

import org.apache.lucene.util.Attribute;

public interface TokenAttribute extends Attribute {
    int[] getTokens();
    void setTokens(int[] tokens);
}
