package com.telek.business.message;

import com.telek.business.annotation.ParamAttrRequire;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/18 10:57
 * @Description: 描述:前后台交互参数对象
 */
public class Param {

    //登录单位
    private String loginCompCode;
    //查询单位
    private String compCode;
    //查询项目编码
    @ParamAttrRequire(maxLength = 12)
    private String itemCode;
    //查询项目名称
    @ParamAttrRequire(maxLength = 50)
    private String itemName;
    //查询年份
    @ParamAttrRequire(maxLength = 4)
    private String year;
    //电压等级
    @ParamAttrRequire(maxLength = 7)
    private String volLevel;
    //计划年份
    @ParamAttrRequire(maxLength = 4)
    private String planYear;
    //非常用字段
    private Map<String, Object> map = new HashMap<>();
    
    //报表ID
    @ParamAttrRequire(maxLength = 20)
    private String reportId;
    //保存行对象数据
    private String rows;
    //计划类型
    @ParamAttrRequire(maxLength = 10)
    private String planType;
    //状态
    private int state;
    //月份
    private int month;
    //专项编码
    private String majorCode;
    //单项类型
    private String prjKind;
    //单项编码
    private String prjCode;
    //单项名称
    @ParamAttrRequire(maxLength = 50)
    private String prjName;
    //WBS编码
    private String wbsCode;
    //项目类别
    private String itemType;
    
    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取查询年份
     */
    public String getYear() {
        return year;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置查询年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取非常用字段
     */
    public Map<String, Object> getMap() {
        return map;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置非常用字段map
     */
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取电压等级
     */
    public String getVolLevel() {
        return volLevel;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置电压等级
     */
    public void setVolLevel(String volLevel) {
        this.volLevel = volLevel;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取计划年份
     */
    public String getPlanYear() {
        return planYear;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置计划年份
     */
    public void setPlanYear(String planYear) {
        this.planYear = planYear;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取登陆单位编码
     */
    public String getLoginCompCode() {
        return loginCompCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置登陆单位编码
     */
    public void setLoginCompCode(String loginCompCode) {
        this.loginCompCode = loginCompCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取查询单位编码
     */
    public String getCompCode() {
        return compCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置查询单位编码
     */
    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取查询项目编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置查询项目编码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取查询项目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置查询项目名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取报表ID
     */
	public String getReportId() {
		return reportId;
	}

	 /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置报表ID
     */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取保存行对象数据
     */
	public String getRows() {
		return rows;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置保存行对象数据
     */
	public void setRows(String rows) {
		this.rows = rows;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取计划类型
     */
	public String getPlanType() {
		return planType;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置计划类型
     */
	public void setPlanType(String planType) {
		this.planType = planType;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取状态
     */
	public int getState() {
		return state;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置状态
     */
	public void setState(int state) {
		this.state = state;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取月份
     */
	public int getMonth() {
		return month;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置月份
     */
	public void setMonth(int month) {
		this.month = month;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取专项编码
     */
	public String getMajorCode() {
		return majorCode;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置专项编码
     */
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取单项类型
     */
	public String getPrjKind() {
		return prjKind;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置单项类型
     */
	public void setPrjKind(String prjKind) {
		this.prjKind = prjKind;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取单项编码
     */
	public String getPrjCode() {
		return prjCode;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置单项编码
     */
	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取单项名称
     */
	public String getPrjName() {
		return prjName;
	}

    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置单项名称
     */
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	
    /**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取WBS编码
     */
	public String getWbsCode() {
		return wbsCode;
	}

	/**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置WBS编码
     */
	public void setWbsCode(String wbsCode) {
		this.wbsCode = wbsCode;
	}

	/**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：获取项目类别
     */
	public String getItemType() {
		return itemType;
	}

	/**
     * @author huangjk       
     * @created 2019年1月23日 下午9:51:34
     * @email jkhuang1995@126.com
     * @return
     * @Description 方法作用：设置项目类别
     */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
