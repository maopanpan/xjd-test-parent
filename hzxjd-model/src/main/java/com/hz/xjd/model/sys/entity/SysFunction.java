package com.hz.xjd.model.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_function")
public class SysFunction implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统功能内部code
     */
    @Column(name = "function_code")
    private String functionCode;

    /**
     * 功能名称
     */
    @Column(name = "function_name")
    private String functionName;

    /**
     * 功能描述
     */
    @Column(name = "function_descr")
    private String functionDescr;

    /**
     * URL
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 所属模块
     */
    @Column(name = "menu_id")
    private Integer menuId;

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
     * 获取系统功能内部code
     *
     * @return function_code - 系统功能内部code
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * 设置系统功能内部code
     *
     * @param functionCode 系统功能内部code
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    /**
     * 获取功能名称
     *
     * @return function_name - 功能名称
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * 设置功能名称
     *
     * @param functionName 功能名称
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    /**
     * 获取功能描述
     *
     * @return function_descr - 功能描述
     */
    public String getFunctionDescr() {
        return functionDescr;
    }

    /**
     * 设置功能描述
     *
     * @param functionDescr 功能描述
     */
    public void setFunctionDescr(String functionDescr) {
        this.functionDescr = functionDescr == null ? null : functionDescr.trim();
    }

    /**
     * 获取URL
     *
     * @return url - URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取所属模块
     *
     * @return menu_id - 所属模块
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置所属模块
     *
     * @param menuId 所属模块
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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
        SysFunction other = (SysFunction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFunctionCode() == null ? other.getFunctionCode() == null : this.getFunctionCode().equals(other.getFunctionCode()))
            && (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
            && (this.getFunctionDescr() == null ? other.getFunctionDescr() == null : this.getFunctionDescr().equals(other.getFunctionDescr()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
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
        result = prime * result + ((getFunctionCode() == null) ? 0 : getFunctionCode().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getFunctionDescr() == null) ? 0 : getFunctionDescr().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
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
        sb.append(", functionCode=").append(functionCode);
        sb.append(", functionName=").append(functionName);
        sb.append(", functionDescr=").append(functionDescr);
        sb.append(", url=").append(url);
        sb.append(", sort=").append(sort);
        sb.append(", menuId=").append(menuId);
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