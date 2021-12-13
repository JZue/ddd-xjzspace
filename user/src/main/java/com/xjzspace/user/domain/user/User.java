package com.xjzspace.user.domain.user;

import com.xjzspace.core.Entity;
import com.xjzspace.user.domain.user.types.Role;

import java.util.Date;
import java.util.List;

public class User implements Entity<Long> {
    private Long id;
    /**
     * 随机分配uid
     **/
    private String uid;

    private String username;

    private String realName;

    private String password;

    private String avatar;

    private String userEmail;
    /**
     * 用户个人站点
     */
    private String userSite;
    /**
     * 最后一次登录时间
     */
    private Date loginLast;

    /**
     * 0 正常
     * 1 禁用
     * 2 已删除
     * 3-匿名用户~会定期删除的
     * 4-后台管理员账号
     */
    private Integer status = 0;

    /**
     * 评论数
     */
    private Integer commentCount;

    private List<Role> roles;

    @Override
    public Long getIdentity() {
        return this.id;
    }


}
