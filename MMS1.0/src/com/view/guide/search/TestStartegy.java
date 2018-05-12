package com.view.guide.search;

import java.util.Arrays;
import java.util.List;

public class TestStartegy implements CondicateStrategy {
    @Override
    public List<String> matchPrefix(String prefix) {
        return Arrays.asList("hah", "heh1", "lueluelue");
    }
}
