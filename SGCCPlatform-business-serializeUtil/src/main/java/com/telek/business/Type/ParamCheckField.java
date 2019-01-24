package com.telek.business.Type;

import java.lang.reflect.Field;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 10:59
 * @Description: 描述:校验field，用于注解中需要校验哪个字段，则使用哪个
 */
public enum ParamCheckField {

    loginCompCode(ParamField.loginCompCode),
    compCode(ParamField.compCode),
    itemCode(ParamField.itemCode),
    itemName(ParamField.itemName),
    year(ParamField.year),
    volLevel(ParamField.volLevel),
    planYear(ParamField.planYear),
    map(ParamField.map),
	
	reportId(ParamField.reportId),
	rows(ParamField.rows),
	planType(ParamField.planType),
	state(ParamField.state),
	month(ParamField.month),
	majorCode(ParamField.majorCode),
	prjKind(ParamField.prjKind),
	prjCode(ParamField.prjCode),
	prjName(ParamField.prjName),
	wbsCode(ParamField.wbsCode),
	itemType(ParamField.itemType);

    public Field field;
    ParamCheckField(Field field) {
        this.field = field;
    }
}
