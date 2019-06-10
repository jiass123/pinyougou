package com.asiainfo.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

import java.math.BigDecimal;


/**
 * 用户表
 *
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-22 16:25:07
 */
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 设置：用户名
     */
    private String username;
    /**
     * 设置：密码，加密存储
     */
    private String password;
    /**
     * 设置：注册手机号
     */
    private String phone;
    /**
     * 设置：注册邮箱
     */
    private String email;
    /**
     * 设置：创建时间
     */
    private Date created;
    /**
     * 设置：
     */
    private Date updated;
    /**
     * 设置：会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    private String sourceType;
    /**
     * 设置：昵称
     */
    private String nickName;
    /**
     * 设置：真实姓名
     */
    private String name;
    /**
     * 设置：使用状态（Y正常 N非正常）
     */
    private String status;
    /**
     * 设置：头像地址
     */
    private String headPic;
    /**
     * 设置：QQ号码
     */
    private String qq;
    /**
     * 设置：账户余额
     */
    private BigDecimal accountBalance;
    /**
     * 设置：手机是否验证 （0否  1是）
     */
    private String isMobileCheck;
    /**
     * 设置：邮箱是否检测（0否  1是）
     */
    private String isEmailCheck;
    /**
     * 设置：性别，1男，2女
     */
    private String sex;
    /**
     * 设置：会员等级
     */
    private Integer userLevel;
    /**
     * 设置：积分
     */
    private Integer points;
    /**
     * 设置：经验值
     */
    private Integer experienceValue;
    /**
     * 设置：生日
     */
    private Date birthday;
    /**
     * 设置：最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码，加密存储
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：注册手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：注册手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：注册邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：注册邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置：
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取：
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置：会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 获取：会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置：昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取：昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置：真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：使用状态（Y正常 N非正常）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：使用状态（Y正常 N非正常）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置：头像地址
     */
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    /**
     * 获取：头像地址
     */
    public String getHeadPic() {
        return headPic;
    }

    /**
     * 设置：QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取：QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置：账户余额
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 获取：账户余额
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置：手机是否验证 （0否  1是）
     */
    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck;
    }

    /**
     * 获取：手机是否验证 （0否  1是）
     */
    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    /**
     * 设置：邮箱是否检测（0否  1是）
     */
    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck;
    }

    /**
     * 获取：邮箱是否检测（0否  1是）
     */
    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    /**
     * 设置：性别，1男，2女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别，1男，2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置：会员等级
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 获取：会员等级
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * 设置：积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取：积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置：经验值
     */
    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    /**
     * 获取：经验值
     */
    public Integer getExperienceValue() {
        return experienceValue;
    }

    /**
     * 设置：生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取：生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置：最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取：最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
}
