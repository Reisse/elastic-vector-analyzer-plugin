package com.ifmo.ve.analyzer;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class VectorTokenFilter extends TokenFilter {
    private final TokenAttribute tokenAttribute = addAttribute(TokenAttribute.class);
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);

    public VectorTokenFilter(TokenStream in) {
        super(in);
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (!input.incrementToken()) {
            return false;
        }

        tokenAttribute.setTokens(new int[]{0, 1, 2, 3});

        // Ideally, we'd only want to have tokens as attribute. But I haven't found a way to use
        // attributes in Elastic (besides just displaying them). So let's replace token text with our vector token.
        String vectorToken = "1 2 3";
        termAttribute.setEmpty();
        termAttribute.append(vectorToken);

        return true;
    }
}
