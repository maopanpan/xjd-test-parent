package com.hz.xjd.model.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log_sys_exception")
public class LogSysException implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 发生时间
     */
    @Column(name = "occur_time")
    private Date occurTime;

    /**
     * 报异常的类
     */
    private String clazz;

    /**
     * 抛的异常
     */
    private String exception;

    /**
     * 异常消息
     */
    private String message;

    /**
     * 异常堆栈信息
     */
    private String stack;

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
     * 获取发生时间
     *
     * @return occur_time - 发生时间
     */
    public Date getOccurTime() {
        return occurTime;
    }

    /**
     * 设置发生时间
     *
     * @param occurTime 发生时间
     */
    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    /**
     * 获取报异常的类
     *
     * @return clazz - 报异常的类
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * 设置报异常的类
     *
     * @param clazz 报异常的类
     */
    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    /**
     * 获取抛的异常
     *
     * @return exception - 抛的异常
     */
    public String getException() {
        return exception;
    }

    /**
     * 设置抛的异常
     *
     * @param exception 抛的异常
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    /**
     * 获取异常消息
     *
     * @return message - 异常消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置异常消息
     *
     * @param message 异常消息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取异常堆栈信息
     *
     * @return stack - 异常堆栈信息
     */
    public String getStack() {
        return stack;
    }

    /**
     * 设置异常堆栈信息
     *
     * @param stack 异常堆栈信息
     */
    public void setStack(String stack) {
        this.stack = stack == null ? null : stack.trim();
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
        LogSysException other = (LogSysException) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOccurTime() == null ? other.getOccurTime() == null : this.getOccurTime().equals(other.getOccurTime()))
            && (this.getClazz() == null ? other.getClazz() == null : this.getClazz().equals(other.getClazz()))
            && (this.getException() == null ? other.getException() == null : this.getException().equals(other.getException()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getStack() == null ? other.getStack() == null : this.getStack().equals(other.getStack()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOccurTime() == null) ? 0 : getOccurTime().hashCode());
        result = prime * result + ((getClazz() == null) ? 0 : getClazz().hashCode());
        result = prime * result + ((getException() == null) ? 0 : getException().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getStack() == null) ? 0 : getStack().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", occurTime=").append(occurTime);
        sb.append(", clazz=").append(clazz);
        sb.append(", exception=").append(exception);
        sb.append(", message=").append(message);
        sb.append(", stack=").append(stack);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}