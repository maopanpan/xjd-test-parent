package com.hz.xjd.model.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统模块内部ID
     */
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 父级系统模块ID
     */
    @Column(name = "parent_menu_id")
    private Integer parentMenuId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单描述
     */
    @Column(name = "menu_descr")
    private String menuDescr;

    /**
     * 菜单排序
     */
    @Column(name = "menu_sort")
    private Integer menuSort;

    /**
     * 是否显示菜单(0否 1是)
     */
    @Column(name = "is_show")
    private Integer isShow;

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
     * 获取系统模块内部ID
     *
     * @return menu_id - 系统模块内部ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置系统模块内部ID
     *
     * @param menuId 系统模块内部ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取父级系统模块ID
     *
     * @return parent_menu_id - 父级系统模块ID
     */
    public Integer getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 设置父级系统模块ID
     *
     * @param parentMenuId 父级系统模块ID
     */
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单描述
     *
     * @return menu_descr - 菜单描述
     */
    public String getMenuDescr() {
        return menuDescr;
    }

    /**
     * 设置菜单描述
     *
     * @param menuDescr 菜单描述
     */
    public void setMenuDescr(String menuDescr) {
        this.menuDescr = menuDescr == null ? null : menuDescr.trim();
    }

    /**
     * 获取菜单排序
     *
     * @return menu_sort - 菜单排序
     */
    public Integer getMenuSort() {
        return menuSort;
    }

    /**
     * 设置菜单排序
     *
     * @param menuSort 菜单排序
     */
    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    /**
     * 获取是否显示菜单(0否 1是)
     *
     * @return is_show - 是否显示菜单(0否 1是)
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示菜单(0否 1是)
     *
     * @param isShow 是否显示菜单(0否 1是)
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
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
        SysMenu other = (SysMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getParentMenuId() == null ? other.getParentMenuId() == null : this.getParentMenuId().equals(other.getParentMenuId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuDescr() == null ? other.getMenuDescr() == null : this.getMenuDescr().equals(other.getMenuDescr()))
            && (this.getMenuSort() == null ? other.getMenuSort() == null : this.getMenuSort().equals(other.getMenuSort()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
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
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getParentMenuId() == null) ? 0 : getParentMenuId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuDescr() == null) ? 0 : getMenuDescr().hashCode());
        result = prime * result + ((getMenuSort() == null) ? 0 : getMenuSort().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
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
        sb.append(", menuId=").append(menuId);
        sb.append(", parentMenuId=").append(parentMenuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuDescr=").append(menuDescr);
        sb.append(", menuSort=").append(menuSort);
        sb.append(", isShow=").append(isShow);
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