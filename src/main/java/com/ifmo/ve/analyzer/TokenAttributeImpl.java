package com.ifmo.ve.analyzer;

import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.AttributeReflector;

public class TokenAttributeImpl extends AttributeImpl implements TokenAttribute {
    private int[] tokens;

    public void setTokens(int[] tokens) {
        this.tokens = tokens;
    }

    public int[] getTokens() {
        return tokens;
    }

    @Override
    public void clear() {
        tokens = new int[] {};
    }

    @Override
    public void copyTo(AttributeImpl target) {
        ((TokenAttributeImpl) target).setTokens(getTokens());
    }

    @Override
    public void reflectWith(AttributeReflector reflector) {
        reflector.reflect(TokenAttribute.class, "tokens", getTokens());
    }
}
