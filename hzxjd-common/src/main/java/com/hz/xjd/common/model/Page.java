package com.hz.xjd.common.model;

import java.io.Serializable;

/**
 *
 * 分页
 *
 */

public class Page implements Serializable {

	private static final long serialVersionUID = -7582896973848371461L;
	/**
	 * 总记录数
	 */
	private int rowCount;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页号
	 */
	private int currPage;
	/**
	 * 每页记录数，默认为：10
	 */
	private int pageSize = 10;
	/**
	 * 起始记录号
	 */
	private int start;

	/**
	 * 构造方法，都采用默认参数
	 */
	public Page() {
		//默认总记录数为0
		this(0);
	}
	/**
	 * 构造方法，默认每页10条记录
	 * @param rowCount
	 */
	public Page(int rowCount) {
		//默认每页10条记录
		this(rowCount, 10);
	}
	/**
	 * 构造方法，默认当前页号为1
	 * @param rowCount
	 * @param pageSize
	 */
	public Page(int rowCount, int pageSize) {
		//默认当前页号为1
		this(rowCount, pageSize, 1);
	}
	/**
	 *
	* 构造方法，设定【总记录数，每页size，当前页号】
	* @param @param rowCount
	* @param @param pageSize
	* @param @param currPage
	 */
	public Page(int rowCount, int pageSize, int currPage) {
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		init();
	}
	/**
	 * 初始化方法，计算出总页数，开始记录号等数值
	 * @return
	 */
	public Page init() {
		this.totalPage = (this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
		if ((this.totalPage < this.currPage) && (this.totalPage > 0)) {
			this.currPage = this.totalPage;
		} else if (this.currPage < 1) {
			this.currPage = 1;
		}
		this.start = ((this.currPage - 1) * this.pageSize);
		return this;
	}

	/**
	 * 得到记录总数
	 * @return 记录总数
	 */
	public int getRowCount() {
		return rowCount;
	}
	/**
	 * 设置记录总数
	 * @param rowCount 记录总数
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * 得到总页数
	 * @return 总页数
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 设置总页数
	 * @param totalPage 总页数
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 得到当前页号
	 * @return 当前页号
	 */
	public int getCurrPage() {
		return currPage;
	}
	/**
	 * 设置当前页号
	 * @param currPage 当前页号
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * 得到每页记录数
	 * @return 每页记录数
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 设置每页记录数
	 * @param pageSize 每页记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 得到起始记录号
	 * @return 起始记录号
	 */
	public int getStart() {
		return start;
	}
}
