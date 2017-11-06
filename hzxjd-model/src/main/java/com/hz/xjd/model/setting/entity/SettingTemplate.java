package com.hz.xjd.model.setting.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "setting_template")
public class SettingTemplate implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模板编号
     */
    @Column(name = "template_no")
    private String templateNo;

    /**
     * 模板名称
     */
    @Column(name = "template_name")
    private String templateName;

    /**
     * 模板版本
     */
    @Column(name = "template_ver")
    private String templateVer;

    /**
     * 模板类型(PDF HTML)
     */
    @Column(name = "template_style")
    private String templateStyle;

    /**
     * 模板类别
     */
    @Column(name = "template_type")
    private String templateType;

    /**
     * 模板适用范围
     */
    @Column(name = "template_scope")
    private String templateScope;

    /**
     * 模板状态
     */
    @Column(name = "template_status")
    private String templateStatus;

    /**
     * 模板排序
     */
    @Column(name = "template_sort")
    private Integer templateSort;

    /**
     * 备注
     */
    private String memo;

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
     * 创建人(系统用户)
     */
    private Integer creator;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 修改人(系统用户)
     */
    private Integer modifier;

    /**
     * 内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模板编号
     *
     * @return template_no - 模板编号
     */
    public String getTemplateNo() {
        return templateNo;
    }

    /**
     * 设置模板编号
     *
     * @param templateNo 模板编号
     */
    public void setTemplateNo(String templateNo) {
        this.templateNo = templateNo == null ? null : templateNo.trim();
    }

    /**
     * 获取模板名称
     *
     * @return template_name - 模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置模板名称
     *
     * @param templateName 模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 获取模板版本
     *
     * @return template_ver - 模板版本
     */
    public String getTemplateVer() {
        return templateVer;
    }

    /**
     * 设置模板版本
     *
     * @param templateVer 模板版本
     */
    public void setTemplateVer(String templateVer) {
        this.templateVer = templateVer == null ? null : templateVer.trim();
    }

    /**
     * 获取模板类型(PDF HTML)
     *
     * @return template_style - 模板类型(PDF HTML)
     */
    public String getTemplateStyle() {
        return templateStyle;
    }

    /**
     * 设置模板类型(PDF HTML)
     *
     * @param templateStyle 模板类型(PDF HTML)
     */
    public void setTemplateStyle(String templateStyle) {
        this.templateStyle = templateStyle == null ? null : templateStyle.trim();
    }

    /**
     * 获取模板类别
     *
     * @return template_type - 模板类别
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 设置模板类别
     *
     * @param templateType 模板类别
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 获取模板适用范围
     *
     * @return template_scope - 模板适用范围
     */
    public String getTemplateScope() {
        return templateScope;
    }

    /**
     * 设置模板适用范围
     *
     * @param templateScope 模板适用范围
     */
    public void setTemplateScope(String templateScope) {
        this.templateScope = templateScope == null ? null : templateScope.trim();
    }

    /**
     * 获取模板状态
     *
     * @return template_status - 模板状态
     */
    public String getTemplateStatus() {
        return templateStatus;
    }

    /**
     * 设置模板状态
     *
     * @param templateStatus 模板状态
     */
    public void setTemplateStatus(String templateStatus) {
        this.templateStatus = templateStatus == null ? null : templateStatus.trim();
    }

    /**
     * 获取模板排序
     *
     * @return template_sort - 模板排序
     */
    public Integer getTemplateSort() {
        return templateSort;
    }

    /**
     * 设置模板排序
     *
     * @param templateSort 模板排序
     */
    public void setTemplateSort(Integer templateSort) {
        this.templateSort = templateSort;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
     * 获取创建人(系统用户)
     *
     * @return creator - 创建人(系统用户)
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 设置创建人(系统用户)
     *
     * @param creator 创建人(系统用户)
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
     * 获取修改人(系统用户)
     *
     * @return modifier - 修改人(系统用户)
     */
    public Integer getModifier() {
        return modifier;
    }

    /**
     * 设置修改人(系统用户)
     *
     * @param modifier 修改人(系统用户)
     */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        SettingTemplate other = (SettingTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTemplateNo() == null ? other.getTemplateNo() == null : this.getTemplateNo().equals(other.getTemplateNo()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getTemplateVer() == null ? other.getTemplateVer() == null : this.getTemplateVer().equals(other.getTemplateVer()))
            && (this.getTemplateStyle() == null ? other.getTemplateStyle() == null : this.getTemplateStyle().equals(other.getTemplateStyle()))
            && (this.getTemplateType() == null ? other.getTemplateType() == null : this.getTemplateType().equals(other.getTemplateType()))
            && (this.getTemplateScope() == null ? other.getTemplateScope() == null : this.getTemplateScope().equals(other.getTemplateScope()))
            && (this.getTemplateStatus() == null ? other.getTemplateStatus() == null : this.getTemplateStatus().equals(other.getTemplateStatus()))
            && (this.getTemplateSort() == null ? other.getTemplateSort() == null : this.getTemplateSort().equals(other.getTemplateSort()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getDeleteFlg() == null ? other.getDeleteFlg() == null : this.getDeleteFlg().equals(other.getDeleteFlg()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTemplateNo() == null) ? 0 : getTemplateNo().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getTemplateVer() == null) ? 0 : getTemplateVer().hashCode());
        result = prime * result + ((getTemplateStyle() == null) ? 0 : getTemplateStyle().hashCode());
        result = prime * result + ((getTemplateType() == null) ? 0 : getTemplateType().hashCode());
        result = prime * result + ((getTemplateScope() == null) ? 0 : getTemplateScope().hashCode());
        result = prime * result + ((getTemplateStatus() == null) ? 0 : getTemplateStatus().hashCode());
        result = prime * result + ((getTemplateSort() == null) ? 0 : getTemplateSort().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getDeleteFlg() == null) ? 0 : getDeleteFlg().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", templateNo=").append(templateNo);
        sb.append(", templateName=").append(templateName);
        sb.append(", templateVer=").append(templateVer);
        sb.append(", templateStyle=").append(templateStyle);
        sb.append(", templateType=").append(templateType);
        sb.append(", templateScope=").append(templateScope);
        sb.append(", templateStatus=").append(templateStatus);
        sb.append(", templateSort=").append(templateSort);
        sb.append(", memo=").append(memo);
        sb.append(", deleteFlg=").append(deleteFlg);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}