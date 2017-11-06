package com.hz.xjd.model.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_org")
public class SysOrg implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织机构内部ID
     */
    @Column(name = "org_id")
    private Integer orgId;

    /**
     * 组织机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 组织机构类型(dept：部门)
     */
    @Column(name = "org_type")
    private String orgType;

    /**
     * 组织机构描述
     */
    @Column(name = "org_descr")
    private String orgDescr;

    /**
     * 父组织机构ID
     */
    @Column(name = "parent_org_id")
    private Integer parentOrgId;

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
     * 获取组织机构内部ID
     *
     * @return org_id - 组织机构内部ID
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 设置组织机构内部ID
     *
     * @param orgId 组织机构内部ID
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取组织机构名称
     *
     * @return org_name - 组织机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置组织机构名称
     *
     * @param orgName 组织机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 获取组织机构类型(dept：部门)
     *
     * @return org_type - 组织机构类型(dept：部门)
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置组织机构类型(dept：部门)
     *
     * @param orgType 组织机构类型(dept：部门)
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * 获取组织机构描述
     *
     * @return org_descr - 组织机构描述
     */
    public String getOrgDescr() {
        return orgDescr;
    }

    /**
     * 设置组织机构描述
     *
     * @param orgDescr 组织机构描述
     */
    public void setOrgDescr(String orgDescr) {
        this.orgDescr = orgDescr == null ? null : orgDescr.trim();
    }

    /**
     * 获取父组织机构ID
     *
     * @return parent_org_id - 父组织机构ID
     */
    public Integer getParentOrgId() {
        return parentOrgId;
    }

    /**
     * 设置父组织机构ID
     *
     * @param parentOrgId 父组织机构ID
     */
    public void setParentOrgId(Integer parentOrgId) {
        this.parentOrgId = parentOrgId;
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
        SysOrg other = (SysOrg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrgType() == null ? other.getOrgType() == null : this.getOrgType().equals(other.getOrgType()))
            && (this.getOrgDescr() == null ? other.getOrgDescr() == null : this.getOrgDescr().equals(other.getOrgDescr()))
            && (this.getParentOrgId() == null ? other.getParentOrgId() == null : this.getParentOrgId().equals(other.getParentOrgId()))
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
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrgType() == null) ? 0 : getOrgType().hashCode());
        result = prime * result + ((getOrgDescr() == null) ? 0 : getOrgDescr().hashCode());
        result = prime * result + ((getParentOrgId() == null) ? 0 : getParentOrgId().hashCode());
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
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgType=").append(orgType);
        sb.append(", orgDescr=").append(orgDescr);
        sb.append(", parentOrgId=").append(parentOrgId);
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