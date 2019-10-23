package com.sankoudai.java.apix.gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sankoudai on 08/08/2018.
 */
public class DataProperty implements Serializable {
    public int hasStock;//1有库存 0无库存
    public int inTime;//1在售 0不在
    public boolean isPreSell;//1预售 0 不预售
    public List<Long> frontCateIds;
    public List<Long> backCateIds;
    public int promotionSecKill;
    public long price;
    public long saleCountWeek;
    public long spuId;
    public String skuExtAttr;
    public int sellType;//售卖类型 1表示正常售卖，2表示即将开售，3表示定期售，4表示明日达, 5表示已抢光

    @Override
    public String toString() {
        return "DataProperty{" +
                "hasStock=" + hasStock +
                ", inTime=" + inTime +
                ", isPreSell=" + isPreSell +
                ", frontCateIds=" + frontCateIds +
                ", backCateIds=" + backCateIds +
                ", promotionSecKill=" + promotionSecKill +
                ", price=" + price +
                ", saleCountWeek=" + saleCountWeek +
                ", spuId=" + spuId +
                ", skuExtAttr='" + skuExtAttr + '\'' +
                ", sellType=" + sellType +
                '}';
    }
}

