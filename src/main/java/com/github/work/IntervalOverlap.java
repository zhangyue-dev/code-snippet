package com.github.work;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Pair;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 区间重叠判断
 */
public class IntervalOverlap {

    /**
     * 判断是否区间重叠 qian
     *
     * @param list 多个区间
     * @return false:未重叠  true:发生重叠 覆盖
     * 示例
     * 1 2 ; 2 3 => true
     * 1 2 ; 3 4 => false
     * 1 2 ; 1 3 => true
     */
    public static boolean checkCover(List<Pair<BigDecimal, BigDecimal>> list) {
        //  如果直接为空, 可以根据业务场景选择抛出业务异常
        if (CollUtil.isEmpty(list)) {
            return false;
        }
        BigDecimal tag = null;
        //  按最大值或最小值进行正序排序
        for (Pair<BigDecimal, BigDecimal> item : CollUtil.sort(list, Comparator.comparing(Pair::getValue))) {
            //  拿每个元素的最小值和排序后前一个元素的最大值进行对比
            if (Objects.nonNull(tag) && item.getKey().compareTo(tag) <= 0) {
                return true;
            }
            tag = item.getValue();
        }
        return false;
    }
}
