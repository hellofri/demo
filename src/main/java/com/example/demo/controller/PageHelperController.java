package com.example.demo.controller;

import com.example.demo.api.CommonPage;
import com.example.demo.api.CommonResult;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/page")
@Api(tags = "PageHelperController")
@Controller
public class PageHelperController {
    @Autowired
    private ScoreService scoreService;

    @ApiOperation("分页测试一下")
    @RequiresPermissions("user:list")
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public CommonResult<CommonPage<Score>> test(int pageNum, int pageSize) {
        return CommonResult.success(CommonPage.restPage(scoreService.test(pageNum,pageSize)));
    }
}
