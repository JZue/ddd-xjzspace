package com.xjzspace.article.persistence.article.dataobject;

import com.xjzspace.core.BaseV2DO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
public class CategoryDO extends BaseV2DO implements Serializable {
    private static final long serialVersionUID = 8383678847517271505L;

    /**
     * 分类名称
     **/
    private String categoryName;

    /**
     * 分类code
     **/
    private String categoryCode;

    /**
     * 分类父节点
     **/
    private Long categoryPid;

    /**
     * 分类层级
     **/
    private Integer categoryLevel;

    /**
     * 分类描述
     **/
    private String categoryDesc;



    private String levelCode;


    /**
     * 分类数量
     **/
    @Transient
    private Integer count;
    /**
     * 分类的子分类~为了WEB的导航栏而加的字段
     **/
    @Transient
    private List<CategoryDO> childCate=new ArrayList<>();


    public void setCategoryPidDefault(Long categoryPid) {
        if (categoryPid==null){
            this.categoryPid =0L;
        }
        this.categoryPid=categoryPid;
    }
}