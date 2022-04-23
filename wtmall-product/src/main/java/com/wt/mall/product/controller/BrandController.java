package com.wt.mall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.wt.common.valid.AddGroup;
import com.wt.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wt.mall.product.entity.BrandEntity;
import com.wt.mall.product.service.BrandService;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 23:07:45
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    //使用@Valid注解表示这个参数需要校验，校验规则写在实体类中
    //BindingResult中保存了校验结果等校验信息，必须紧跟在校验参数的后面声明
    //使用@Validated注解来表示本次请求校验属于哪个组，需要接口
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand/*, BindingResult result*/){
        //下面注掉是因为交给了统一异常处理的类
//       //将校验结果放到R中响应给前端
//        if (result.hasErrors()){ //如果校验出错
//            //这个map用来放校验信息
//            Map<String,String> map = new HashMap<>();
//            //遍历每一个出错的校验字段
//            for (FieldError fieldError : result.getFieldErrors()) {
//                //获取字段名
//                String field = fieldError.getField();
//                //获取字段上的校验message
//                String message = fieldError.getDefaultMessage();
//                map.put(field,message);
//            }
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }

        brandService.save(brand);
        return R.ok();

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
