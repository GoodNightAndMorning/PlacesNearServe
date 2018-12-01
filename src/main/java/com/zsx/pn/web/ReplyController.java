package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.entity.Reply;
import com.zsx.pn.model.ReplyModel.AddReplyModel;
import com.zsx.pn.model.ReplyModel.QueryReplyListModel;
import com.zsx.pn.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "addReply", method = RequestMethod.POST)
    public BaseDto addReply(@Valid AddReplyModel model,
                            BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            replyService.addReply(model);

            return BaseResult.success("添加评论成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "queryReplyList", method = RequestMethod.GET)
    public BaseDto<List<Reply>> queryReplyList(@Valid QueryReplyListModel model,
                                               BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }
        try {
            List<Reply> list = replyService.queryReplyList(model);

            return BaseResult.success(list, "获取回复列表成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}
