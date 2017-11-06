package com.hz.xjd.model.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_detail")
public class UserDetail implements Serializable {
    /**
     * 用户编号(内部用)
     */
    @Id
    @Column(name = "user_no")
    private String userNo;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 民族
     */
    private String family;

    /**
     * 居住所在区域code
     */
    @Column(name = "home_region")
    private Integer homeRegion;

    /**
     * 居住详细地址
     */
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 居住时长(单位：年？)
     */
    @Column(name = "live_time")
    private String liveTime;

    /**
     * 座机号码
     */
    @Column(name = "home_telephone")
    private String homeTelephone;

    /**
     * 学历[专科（高职、高专、高技）、本科 、硕士、博士]
     */
    private String education;

    /**
     * 婚姻状况(unmarried:未婚,married:已婚,divorced:离异,lost:丧偶)
     */
    private String married;

    /**
     * 育儿状况(已育 未育)
     */
    @Column(name = "parenting_status")
    private String parentingStatus;

    /**
     * 子女个数
     */
    @Column(name = "children_number")
    private String childrenNumber;

    /**
     * 单位名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 单位所在区域code
     */
    @Column(name = "company_region")
    private Integer companyRegion;

    /**
     * 单位详细地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 单位座机号码
     */
    @Column(name = "company_telephone")
    private String companyTelephone;

    /**
     * 职位
     */
    private String job;

    /**
     * 收入
     */
    private String salary;

    /**
     * 头像图片url
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 户籍所在区域code
     */
    @Column(name = "origin_region")
    private Integer originRegion;

    /**
     * 户籍详细地址
     */
    @Column(name = "origin_address")
    private String originAddress;

    /**
     * 第一联系人姓名
     */
    @Column(name = "first_contact_name")
    private String firstContactName;

    /**
     * 与第一联系人关系类型
     */
    @Column(name = "first_contact_relation")
    private String firstContactRelation;

    /**
     * 第一联系人手机号
     */
    @Column(name = "first_contact_mobile")
    private String firstContactMobile;

    /**
     * 第二联系人姓名
     */
    @Column(name = "second_contact_name")
    private String secondContactName;

    /**
     * 与第二联系人关系类型
     */
    @Column(name = "second_contact_relation")
    private String secondContactRelation;

    /**
     * 第二联系人手机号
     */
    @Column(name = "second_contact_mobile")
    private String secondContactMobile;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户编号(内部用)
     *
     * @return user_no - 用户编号(内部用)
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户编号(内部用)
     *
     * @param userNo 用户编号(内部用)
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取民族
     *
     * @return family - 民族
     */
    public String getFamily() {
        return family;
    }

    /**
     * 设置民族
     *
     * @param family 民族
     */
    public void setFamily(String family) {
        this.family = family == null ? null : family.trim();
    }

    /**
     * 获取居住所在区域code
     *
     * @return home_region - 居住所在区域code
     */
    public Integer getHomeRegion() {
        return homeRegion;
    }

    /**
     * 设置居住所在区域code
     *
     * @param homeRegion 居住所在区域code
     */
    public void setHomeRegion(Integer homeRegion) {
        this.homeRegion = homeRegion;
    }

    /**
     * 获取居住详细地址
     *
     * @return home_address - 居住详细地址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置居住详细地址
     *
     * @param homeAddress 居住详细地址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    /**
     * 获取居住时长(单位：年？)
     *
     * @return live_time - 居住时长(单位：年？)
     */
    public String getLiveTime() {
        return liveTime;
    }

    /**
     * 设置居住时长(单位：年？)
     *
     * @param liveTime 居住时长(单位：年？)
     */
    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime == null ? null : liveTime.trim();
    }

    /**
     * 获取座机号码
     *
     * @return home_telephone - 座机号码
     */
    public String getHomeTelephone() {
        return homeTelephone;
    }

    /**
     * 设置座机号码
     *
     * @param homeTelephone 座机号码
     */
    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone == null ? null : homeTelephone.trim();
    }

    /**
     * 获取学历[专科（高职、高专、高技）、本科 、硕士、博士]
     *
     * @return education - 学历[专科（高职、高专、高技）、本科 、硕士、博士]
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历[专科（高职、高专、高技）、本科 、硕士、博士]
     *
     * @param education 学历[专科（高职、高专、高技）、本科 、硕士、博士]
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 获取婚姻状况(unmarried:未婚,married:已婚,divorced:离异,lost:丧偶)
     *
     * @return married - 婚姻状况(unmarried:未婚,married:已婚,divorced:离异,lost:丧偶)
     */
    public String getMarried() {
        return married;
    }

    /**
     * 设置婚姻状况(unmarried:未婚,married:已婚,divorced:离异,lost:丧偶)
     *
     * @param married 婚姻状况(unmarried:未婚,married:已婚,divorced:离异,lost:丧偶)
     */
    public void setMarried(String married) {
        this.married = married == null ? null : married.trim();
    }

    /**
     * 获取育儿状况(已育 未育)
     *
     * @return parenting_status - 育儿状况(已育 未育)
     */
    public String getParentingStatus() {
        return parentingStatus;
    }

    /**
     * 设置育儿状况(已育 未育)
     *
     * @param parentingStatus 育儿状况(已育 未育)
     */
    public void setParentingStatus(String parentingStatus) {
        this.parentingStatus = parentingStatus == null ? null : parentingStatus.trim();
    }

    /**
     * 获取子女个数
     *
     * @return children_number - 子女个数
     */
    public String getChildrenNumber() {
        return childrenNumber;
    }

    /**
     * 设置子女个数
     *
     * @param childrenNumber 子女个数
     */
    public void setChildrenNumber(String childrenNumber) {
        this.childrenNumber = childrenNumber == null ? null : childrenNumber.trim();
    }

    /**
     * 获取单位名称
     *
     * @return company_name - 单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置单位名称
     *
     * @param companyName 单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取单位所在区域code
     *
     * @return company_region - 单位所在区域code
     */
    public Integer getCompanyRegion() {
        return companyRegion;
    }

    /**
     * 设置单位所在区域code
     *
     * @param companyRegion 单位所在区域code
     */
    public void setCompanyRegion(Integer companyRegion) {
        this.companyRegion = companyRegion;
    }

    /**
     * 获取单位详细地址
     *
     * @return company_address - 单位详细地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置单位详细地址
     *
     * @param companyAddress 单位详细地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取单位座机号码
     *
     * @return company_telephone - 单位座机号码
     */
    public String getCompanyTelephone() {
        return companyTelephone;
    }

    /**
     * 设置单位座机号码
     *
     * @param companyTelephone 单位座机号码
     */
    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone == null ? null : companyTelephone.trim();
    }

    /**
     * 获取职位
     *
     * @return job - 职位
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置职位
     *
     * @param job 职位
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * 获取收入
     *
     * @return salary - 收入
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 设置收入
     *
     * @param salary 收入
     */
    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    /**
     * 获取头像图片url
     *
     * @return head_img_url - 头像图片url
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置头像图片url
     *
     * @param headImgUrl 头像图片url
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    /**
     * 获取户籍所在区域code
     *
     * @return origin_region - 户籍所在区域code
     */
    public Integer getOriginRegion() {
        return originRegion;
    }

    /**
     * 设置户籍所在区域code
     *
     * @param originRegion 户籍所在区域code
     */
    public void setOriginRegion(Integer originRegion) {
        this.originRegion = originRegion;
    }

    /**
     * 获取户籍详细地址
     *
     * @return origin_address - 户籍详细地址
     */
    public String getOriginAddress() {
        return originAddress;
    }

    /**
     * 设置户籍详细地址
     *
     * @param originAddress 户籍详细地址
     */
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress == null ? null : originAddress.trim();
    }

    /**
     * 获取第一联系人姓名
     *
     * @return first_contact_name - 第一联系人姓名
     */
    public String getFirstContactName() {
        return firstContactName;
    }

    /**
     * 设置第一联系人姓名
     *
     * @param firstContactName 第一联系人姓名
     */
    public void setFirstContactName(String firstContactName) {
        this.firstContactName = firstContactName == null ? null : firstContactName.trim();
    }

    /**
     * 获取与第一联系人关系类型
     *
     * @return first_contact_relation - 与第一联系人关系类型
     */
    public String getFirstContactRelation() {
        return firstContactRelation;
    }

    /**
     * 设置与第一联系人关系类型
     *
     * @param firstContactRelation 与第一联系人关系类型
     */
    public void setFirstContactRelation(String firstContactRelation) {
        this.firstContactRelation = firstContactRelation == null ? null : firstContactRelation.trim();
    }

    /**
     * 获取第一联系人手机号
     *
     * @return first_contact_mobile - 第一联系人手机号
     */
    public String getFirstContactMobile() {
        return firstContactMobile;
    }

    /**
     * 设置第一联系人手机号
     *
     * @param firstContactMobile 第一联系人手机号
     */
    public void setFirstContactMobile(String firstContactMobile) {
        this.firstContactMobile = firstContactMobile == null ? null : firstContactMobile.trim();
    }

    /**
     * 获取第二联系人姓名
     *
     * @return second_contact_name - 第二联系人姓名
     */
    public String getSecondContactName() {
        return secondContactName;
    }

    /**
     * 设置第二联系人姓名
     *
     * @param secondContactName 第二联系人姓名
     */
    public void setSecondContactName(String secondContactName) {
        this.secondContactName = secondContactName == null ? null : secondContactName.trim();
    }

    /**
     * 获取与第二联系人关系类型
     *
     * @return second_contact_relation - 与第二联系人关系类型
     */
    public String getSecondContactRelation() {
        return secondContactRelation;
    }

    /**
     * 设置与第二联系人关系类型
     *
     * @param secondContactRelation 与第二联系人关系类型
     */
    public void setSecondContactRelation(String secondContactRelation) {
        this.secondContactRelation = secondContactRelation == null ? null : secondContactRelation.trim();
    }

    /**
     * 获取第二联系人手机号
     *
     * @return second_contact_mobile - 第二联系人手机号
     */
    public String getSecondContactMobile() {
        return secondContactMobile;
    }

    /**
     * 设置第二联系人手机号
     *
     * @param secondContactMobile 第二联系人手机号
     */
    public void setSecondContactMobile(String secondContactMobile) {
        this.secondContactMobile = secondContactMobile == null ? null : secondContactMobile.trim();
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
        UserDetail other = (UserDetail) that;
        return (this.getUserNo() == null ? other.getUserNo() == null : this.getUserNo().equals(other.getUserNo()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getFamily() == null ? other.getFamily() == null : this.getFamily().equals(other.getFamily()))
            && (this.getHomeRegion() == null ? other.getHomeRegion() == null : this.getHomeRegion().equals(other.getHomeRegion()))
            && (this.getHomeAddress() == null ? other.getHomeAddress() == null : this.getHomeAddress().equals(other.getHomeAddress()))
            && (this.getLiveTime() == null ? other.getLiveTime() == null : this.getLiveTime().equals(other.getLiveTime()))
            && (this.getHomeTelephone() == null ? other.getHomeTelephone() == null : this.getHomeTelephone().equals(other.getHomeTelephone()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMarried() == null ? other.getMarried() == null : this.getMarried().equals(other.getMarried()))
            && (this.getParentingStatus() == null ? other.getParentingStatus() == null : this.getParentingStatus().equals(other.getParentingStatus()))
            && (this.getChildrenNumber() == null ? other.getChildrenNumber() == null : this.getChildrenNumber().equals(other.getChildrenNumber()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyRegion() == null ? other.getCompanyRegion() == null : this.getCompanyRegion().equals(other.getCompanyRegion()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyTelephone() == null ? other.getCompanyTelephone() == null : this.getCompanyTelephone().equals(other.getCompanyTelephone()))
            && (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getHeadImgUrl() == null ? other.getHeadImgUrl() == null : this.getHeadImgUrl().equals(other.getHeadImgUrl()))
            && (this.getOriginRegion() == null ? other.getOriginRegion() == null : this.getOriginRegion().equals(other.getOriginRegion()))
            && (this.getOriginAddress() == null ? other.getOriginAddress() == null : this.getOriginAddress().equals(other.getOriginAddress()))
            && (this.getFirstContactName() == null ? other.getFirstContactName() == null : this.getFirstContactName().equals(other.getFirstContactName()))
            && (this.getFirstContactRelation() == null ? other.getFirstContactRelation() == null : this.getFirstContactRelation().equals(other.getFirstContactRelation()))
            && (this.getFirstContactMobile() == null ? other.getFirstContactMobile() == null : this.getFirstContactMobile().equals(other.getFirstContactMobile()))
            && (this.getSecondContactName() == null ? other.getSecondContactName() == null : this.getSecondContactName().equals(other.getSecondContactName()))
            && (this.getSecondContactRelation() == null ? other.getSecondContactRelation() == null : this.getSecondContactRelation().equals(other.getSecondContactRelation()))
            && (this.getSecondContactMobile() == null ? other.getSecondContactMobile() == null : this.getSecondContactMobile().equals(other.getSecondContactMobile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserNo() == null) ? 0 : getUserNo().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getFamily() == null) ? 0 : getFamily().hashCode());
        result = prime * result + ((getHomeRegion() == null) ? 0 : getHomeRegion().hashCode());
        result = prime * result + ((getHomeAddress() == null) ? 0 : getHomeAddress().hashCode());
        result = prime * result + ((getLiveTime() == null) ? 0 : getLiveTime().hashCode());
        result = prime * result + ((getHomeTelephone() == null) ? 0 : getHomeTelephone().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMarried() == null) ? 0 : getMarried().hashCode());
        result = prime * result + ((getParentingStatus() == null) ? 0 : getParentingStatus().hashCode());
        result = prime * result + ((getChildrenNumber() == null) ? 0 : getChildrenNumber().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyRegion() == null) ? 0 : getCompanyRegion().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyTelephone() == null) ? 0 : getCompanyTelephone().hashCode());
        result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getHeadImgUrl() == null) ? 0 : getHeadImgUrl().hashCode());
        result = prime * result + ((getOriginRegion() == null) ? 0 : getOriginRegion().hashCode());
        result = prime * result + ((getOriginAddress() == null) ? 0 : getOriginAddress().hashCode());
        result = prime * result + ((getFirstContactName() == null) ? 0 : getFirstContactName().hashCode());
        result = prime * result + ((getFirstContactRelation() == null) ? 0 : getFirstContactRelation().hashCode());
        result = prime * result + ((getFirstContactMobile() == null) ? 0 : getFirstContactMobile().hashCode());
        result = prime * result + ((getSecondContactName() == null) ? 0 : getSecondContactName().hashCode());
        result = prime * result + ((getSecondContactRelation() == null) ? 0 : getSecondContactRelation().hashCode());
        result = prime * result + ((getSecondContactMobile() == null) ? 0 : getSecondContactMobile().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userNo=").append(userNo);
        sb.append(", birthday=").append(birthday);
        sb.append(", family=").append(family);
        sb.append(", homeRegion=").append(homeRegion);
        sb.append(", homeAddress=").append(homeAddress);
        sb.append(", liveTime=").append(liveTime);
        sb.append(", homeTelephone=").append(homeTelephone);
        sb.append(", education=").append(education);
        sb.append(", married=").append(married);
        sb.append(", parentingStatus=").append(parentingStatus);
        sb.append(", childrenNumber=").append(childrenNumber);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyRegion=").append(companyRegion);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyTelephone=").append(companyTelephone);
        sb.append(", job=").append(job);
        sb.append(", salary=").append(salary);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", originRegion=").append(originRegion);
        sb.append(", originAddress=").append(originAddress);
        sb.append(", firstContactName=").append(firstContactName);
        sb.append(", firstContactRelation=").append(firstContactRelation);
        sb.append(", firstContactMobile=").append(firstContactMobile);
        sb.append(", secondContactName=").append(secondContactName);
        sb.append(", secondContactRelation=").append(secondContactRelation);
        sb.append(", secondContactMobile=").append(secondContactMobile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}