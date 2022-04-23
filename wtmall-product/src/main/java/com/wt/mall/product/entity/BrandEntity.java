package com.wt.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.wt.common.valid.AddGroup;
import com.wt.common.valid.ListValue;
import com.wt.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 22:29:12
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	//groups指的是分组，必须在这些条件下此校验注解才生效，需要接口用来标识分组
	@NotNull(message = "修改时必须指定id", groups = {UpdateGroup.class})
	@Null(message = "新增时不能带id", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	//使用这些注解来标识校验的规则，message表示自己定制的校验错误提示信息
	@NotBlank(message = "品牌名不能为空", groups = {UpdateGroup.class,AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(groups = {AddGroup.class})
	@URL(message = "logo必须是一个合法的URL地址", groups = {UpdateGroup.class,AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	//使用自定义校验规则，自己写一个注解
	//这个注解的规则是值必须是0or1
	@ListValue(vals={0,1}, groups = {UpdateGroup.class,AddGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	//自定义的校验规则使用@Pattern注解然后传入一个正则表达式
	@Pattern(regexp = "/^[a-zA-Z]$/", message = "首字母必须是一个英文字母", groups = {UpdateGroup.class,AddGroup.class})
	@NotBlank(groups = {AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = {AddGroup.class})
	@Min(value = 0, message = "排序数字必须大于等于0", groups = {UpdateGroup.class,AddGroup.class})
	private Integer sort;

}
