package com.hz.xjd.model.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统用户内部id
     */
    @Column(name = "sys_user_id")
    private Integer sysUserId;

    /**
     * 帐号
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名称
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户状态(disable禁用 enable正常)
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 是否是超级用户(0非 1是)
     */
    @Column(name = "is_sys")
    private Integer isSys;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 部门组织编号
     */
    @Column(name = "org_id")
    private Integer orgId;

    /**
     * 员工编号
     */
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login")
    private Date lastLogin;

    /**
     * 删除标示(0:未删除 1:删除)
     */
    @Column(name = "delete_flg")
    private Integer deleteFlg;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 修改人
     */
    private Integer modifier;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取系统用户内部id
     *
     * @return sys_user_id - 系统用户内部id
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置系统用户内部id
     *
     * @param sysUserId 系统用户内部id
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取帐号
     *
     * @return login_name - 帐号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置帐号
     *
     * @param loginName 帐号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取真实名称
     *
     * @return real_name - 真实名称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实名称
     *
     * @param realName 真实名称
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取用户状态(disable禁用 enable正常)
     *
     * @return user_status - 用户状态(disable禁用 enable正常)
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态(disable禁用 enable正常)
     *
     * @param userStatus 用户状态(disable禁用 enable正常)
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 获取是否是超级用户(0非 1是)
     *
     * @return is_sys - 是否是超级用户(0非 1是)
     */
    public Integer getIsSys() {
        return isSys;
    }

    /**
     * 设置是否是超级用户(0非 1是)
     *
     * @param isSys 是否是超级用户(0非 1是)
     */
    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
    }

    /**
     * 获取联系电话
     *
     * @return mobile - 联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系电话
     *
     * @param mobile 联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 获取部门组织编号
     *
     * @return org_id - 部门组织编号
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 设置部门组织编号
     *
     * @param orgId 部门组织编号
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取员工编号
     *
     * @return employee_id - 员工编号
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工编号
     *
     * @param employeeId 员工编号
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login - 最后登录时间
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLogin 最后登录时间
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 获取删除标示(0:未删除 1:删除)
     *
     * @return delete_flg - 删除标示(0:未删除 1:删除)
     */
    public Integer getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * 设置删除标示(0:未删除 1:删除)
     *
     * @param deleteFlg 删除标示(0:未删除 1:删除)
     */
    public void setDeleteFlg(Integer deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public Integer getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getIsSys() == null ? other.getIsSys() == null : this.getIsSys().equals(other.getIsSys()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMail() == null ? other.getMail() == null : this.getMail().equals(other.getMail()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getDeleteFlg() == null ? other.getDeleteFlg() == null : this.getDeleteFlg().equals(other.getDeleteFlg()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getIsSys() == null) ? 0 : getIsSys().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getDeleteFlg() == null) ? 0 : getDeleteFlg().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", birthday=").append(birthday);
        sb.append(", sex=").append(sex);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", isSys=").append(isSys);
        sb.append(", mobile=").append(mobile);
        sb.append(", mail=").append(mail);
        sb.append(", orgId=").append(orgId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", userType=").append(userType);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", deleteFlg=").append(deleteFlg);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}