package com.yacoding.courseware.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yacoding.courseware.mapper.CoursewareMapper;
import com.yacoding.courseware.pojo.Courseware;
import com.yacoding.courseware.common.CommonPage;
import com.yacoding.courseware.common.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yaCoding
 * @create 2022-07-27 下午 1:56
 */

@Service
public class CoursewareService {

    @Resource
    private CoursewareMapper coursewareMapper;

    public Result list(Integer start) {
        /**
         * 1.用mybatis plus分页查询功能 查询
         * 2.返回IPage 对象， 转换为CommonPage即可
         */
        Page<Courseware> page = new Page<>(start, 10);
        Page<Courseware> coursewareIPage = coursewareMapper.selectPage(page, new LambdaQueryWrapper<>());
        CommonPage<Courseware> coursewareCommonPage = CommonPage.restPage(coursewareIPage);
        List<Courseware> collect = coursewareCommonPage.getList().stream().peek(courseware -> courseware.setUrl(null)).collect(Collectors.toList());
        coursewareCommonPage.setList(collect);
        return Result.SUCCESS(coursewareCommonPage);
    }


    public Result getCarousel() {
        LambdaQueryWrapper<Courseware> queryWrapper = Wrappers.<Courseware>lambdaQuery().gt(Courseware::getIsCarousel, 0).orderByAsc(Courseware::getIsCarousel);
        queryWrapper.select(Courseware::getId,Courseware::getCarouselUrl);
        List<Courseware> coursewareList = coursewareMapper.selectList(queryWrapper);
        return Result.SUCCESS(coursewareList);
    }
}
