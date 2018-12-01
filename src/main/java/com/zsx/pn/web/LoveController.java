package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.entity.Love;
import com.zsx.pn.model.AddLoveModel;
import com.zsx.pn.model.CancelLoveModel;
import com.zsx.pn.model.QueryLoveListModel;
import com.zsx.pn.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("love")
public class LoveController {

    @Autowired
    private LoveService loveService;

    @RequestMapping(value = "addLove", method = RequestMethod.POST)
    public BaseDto addLove(@Valid AddLoveModel loveModel,
                           BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            loveService.addLove(loveModel);

            return BaseResult.success("点赞成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
    @RequestMapping(value = "queryLoveList", method = RequestMethod.GET)
    public BaseDto<List<Love>> queryLoveList(@Valid QueryLoveListModel listModel,
                                             BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            List<Love> list = loveService.queryLoveList(listModel);
            return BaseResult.success(list, "获取点赞列表成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
    @RequestMapping(value = "cancelLove", method = RequestMethod.POST)
    public BaseDto queryLoveList(@Valid CancelLoveModel loveModel,
                                             BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            loveService.cancelLove(loveModel);
            return BaseResult.success("取消点赞成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}
