package com.xjzspace.article.domain.menu;

import com.xjzspace.core.IAggregateRoot;
import com.xjzspace.core.annotation.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class Menu implements IAggregateRoot<Long> {

    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 排序编号
     */
    private Integer menuSort;

    /**
     * 图标，可选，部分主题可显示
     */
    private String menuIcon;

    /**
     * 菜单层级
     */
    private Integer menuLevel;

    /**
     * 层级编码~体现层级关系~面包屑用
     **/
    private String levleCode;

    /**
     * 菜单类型(0-Web主要菜单，1-admin顶部菜单)
     */
    private Integer menuType;

    /**
     * 子菜单列表
     */
    private List<Menu> childMenus;

    /**
     * 父级ID
     **/
    private Menu menuParent;

    @Override
    public Long getIdentity() {
        return this.menuId;
    }
}
