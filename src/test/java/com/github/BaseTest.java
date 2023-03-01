package com.github;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.lang.mutable.MutablePair;
import com.github.work.IntervalOverlap;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    @Test
    public void testCover() {
        List<Pair<BigDecimal, BigDecimal>> itemList = new ArrayList<>();
        itemList.add(MutablePair.of(new BigDecimal("1"), new BigDecimal("3")));
        itemList.add(MutablePair.of(new BigDecimal("3"), new BigDecimal("4")));
        System.err.println(IntervalOverlap.checkCover(itemList));
    }
}
