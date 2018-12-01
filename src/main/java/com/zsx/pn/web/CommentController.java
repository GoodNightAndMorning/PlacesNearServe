package com.zsx.pn.web;

import com.github.pagehelper.PageInfo;
import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BasePageInfo;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.entity.Commen;
import com.zsx.pn.model.CommentModel.AddCommentModel;
import com.zsx.pn.model.CommentModel.DeleteCommentModel;
import com.zsx.pn.model.CommentModel.QueryCommentListModel;
import com.zsx.pn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public BaseDto<Commen> addComment(@Valid AddCommentModel model,
                              BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            Commen commen = commentService.addComment(model);
            return BaseResult.success(commen, "添加评论成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 删除评论
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public BaseDto deleteComment(@Valid DeleteCommentModel model,
                                 BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            commentService.deleteComment(model);

            return BaseResult.success("删除评论成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 获取评论列表
     * @param model
     * @param result
     * @return
     */
    @RequestMapping(value = "queryCommentList", method = RequestMethod.GET)
    public BaseDto<PageInfo<Commen>> queryCommentList(@Valid QueryCommentListModel model,
                                                      BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            List<Commen> list = commentService.queryCommentList(model);
            PageInfo<Commen> pageInfo = new PageInfo<>(list);

            return BaseResult.success(new BasePageInfo(pageInfo), "获取评论列表成");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}
