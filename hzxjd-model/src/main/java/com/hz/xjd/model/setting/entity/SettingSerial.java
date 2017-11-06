package com.hz.xjd.model.setting.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "setting_serial")
public class SettingSerial implements Serializable {
    /**
     * 编号前缀
     */
    @Id
    private String prefix;

    /**
     * 序号
     */
    @Column(name = "serial_num")
    private String serialNum;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号前缀
     *
     * @return prefix - 编号前缀
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 设置编号前缀
     *
     * @param prefix 编号前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    /**
     * 获取序号
     *
     * @return serial_num - 序号
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序号
     *
     * @param serialNum 序号
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
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
        SettingSerial other = (SettingSerial) that;
        return (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
            && (this.getSerialNum() == null ? other.getSerialNum() == null : this.getSerialNum().equals(other.getSerialNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
        result = prime * result + ((getSerialNum() == null) ? 0 : getSerialNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prefix=").append(prefix);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}