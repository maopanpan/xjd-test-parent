package com.hz.xjd.model.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log_user_login")
public class LogUserLogin implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录手机号
     */
    private String mobile;

    /**
     * 登录用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * 登录是否成功
     */
    private String success;

    /**
     * 1:用户名密码错误 2:用户锁定 3:拉黑
     */
    @Column(name = "fail_cuase")
    private String failCuase;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录手机号
     *
     * @return mobile - 登录手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置登录手机号
     *
     * @param mobile 登录手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取登录用户编号
     *
     * @return user_no - 登录用户编号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置登录用户编号
     *
     * @param userNo 登录用户编号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登录IP
     *
     * @return ip - 登录IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置登录IP
     *
     * @param ip 登录IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取登录是否成功
     *
     * @return success - 登录是否成功
     */
    public String getSuccess() {
        return success;
    }

    /**
     * 设置登录是否成功
     *
     * @param success 登录是否成功
     */
    public void setSuccess(String success) {
        this.success = success == null ? null : success.trim();
    }

    /**
     * 获取1:用户名密码错误 2:用户锁定 3:拉黑
     *
     * @return fail_cuase - 1:用户名密码错误 2:用户锁定 3:拉黑
     */
    public String getFailCuase() {
        return failCuase;
    }

    /**
     * 设置1:用户名密码错误 2:用户锁定 3:拉黑
     *
     * @param failCuase 1:用户名密码错误 2:用户锁定 3:拉黑
     */
    public void setFailCuase(String failCuase) {
        this.failCuase = failCuase == null ? null : failCuase.trim();
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
        LogUserLogin other = (LogUserLogin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getSuccess() == null ? other.getSuccess() == null : this.getSuccess().equals(other.getSuccess()))
            && (this.getFailCuase() == null ? other.getFailCuase() == null : this.getFailCuase().equals(other.getFailCuase()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getSuccess() == null) ? 0 : getSuccess().hashCode());
        result = prime * result + ((getFailCuase() == null) ? 0 : getFailCuase().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append(", userNo=").append(userNo);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", ip=").append(ip);
        sb.append(", success=").append(success);
        sb.append(", failCuase=").append(failCuase);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}