package com.zsx.pn.web;

import com.github.pagehelper.PageInfo;
import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.dto.MyPageInfo;
import com.zsx.pn.entity.Attention;

import com.zsx.pn.model.Attention.AddAttentionModel;
import com.zsx.pn.model.Attention.CancelAttentionModel;
import com.zsx.pn.model.Attention.HasAttentionModel;
import com.zsx.pn.model.Attention.QueryAttentionListModel;

import com.zsx.pn.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("attention")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    /**
     * 关注
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "addAttention", method = RequestMethod.POST)
    public BaseDto addAttention(@Valid AddAttentionModel model,
                                BindingResult result) {

        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            attentionService.addAttention(model);

            return BaseResult.success("关注成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 判断是否已经关注
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "hasAttention", method = RequestMethod.GET)
    public BaseDto<Boolean> hasAttention(@Valid HasAttentionModel model,
                                         BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }
        try {
            Boolean hasAttention = attentionService.hasAttention(model);

            return BaseResult.success(hasAttention, "获取是否收藏状态成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 取消关注
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "cancelAttention", method = RequestMethod.POST)
    public BaseDto cancelAttention(@Valid CancelAttentionModel model,
                                   BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }
        try {
            attentionService.cancelAttention(model);

            return BaseResult.success("取消收藏成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "queryAttentionList", method = RequestMethod.GET)
    public BaseDto<MyPageInfo<Attention>> queryAttentionList(@Valid QueryAttentionListModel model,
                                                           BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }
        try {
            model.enablePaging();
            List<Attention> list = attentionService.queryAttentionList(model);
            PageInfo<Attention> pageInfo = new PageInfo<Attention>(list);

            MyPageInfo<Attention> myPageInfo = new MyPageInfo<>(pageInfo.getSize(),pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());

            return BaseResult.success(myPageInfo, "获取关注列表成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}
