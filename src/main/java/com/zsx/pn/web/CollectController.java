package com.zsx.pn.web;

import com.github.pagehelper.PageInfo;
import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.dto.MyPageInfo;
import com.zsx.pn.entity.Collect;
import com.zsx.pn.model.CollectModel.AddCollectModel;
import com.zsx.pn.model.CollectModel.CancelCollectModel;
import com.zsx.pn.model.CollectModel.QueryCollectListModel;
import com.zsx.pn.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "addCollect", method = RequestMethod.POST)
    public BaseDto addCollect(@Valid AddCollectModel model,
                              BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            collectService.addCollect(model);

            return BaseResult.success("收藏成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "cancelCollect", method = RequestMethod.POST)
    public BaseDto cancelCollect(@Valid CancelCollectModel model,
                                 BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            collectService.cancelCollect(model);

            return BaseResult.success("取消收藏成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "queryCollectList", method = RequestMethod.GET)
    public BaseDto<MyPageInfo<Collect>> queryCollectList(@Valid QueryCollectListModel model,
                                                       BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }
        try {
            model.enablePaging();
            List<Collect> list = collectService.queryCollectList(model);
            PageInfo<Collect> pageInfo = new PageInfo<Collect>(list);

            MyPageInfo<Collect> myPageInfo = new MyPageInfo<>(pageInfo.getSize(),pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());

            return BaseResult.success(myPageInfo, "获取收藏列表成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}
