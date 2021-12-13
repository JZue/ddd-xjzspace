package com.xjzspace.article.domain.series;

import com.xjzspace.article.domain.series.types.SeriesItem;
import com.xjzspace.core.IAggregateRoot;
import com.xjzspace.core.annotation.AggregateRoot;

import java.util.List;

@AggregateRoot
public class Series implements IAggregateRoot<Long> {

    private Long seriesId;

    private String seriesTitle;

    private String seriesCode;

    private String description;

    /**
     * 封面图
     */
    private String picUrl;

    private List<SeriesItem> seriesItemList;
    @Override
    public Long getIdentity() {
        return this.seriesId;
    }
}
