package com.xjzspace.article.api.article;


import com.xjzspace.article.api.article.dto.ArticleDetailDTO;
import com.xjzspace.article.api.article.dto.ArticleRecommendDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArticleController {

    @GetMapping(value = { "/page/{articleUrl}"})
    @JzueLog
    public String getArticleByUrl(@PathVariable String articleUrl, Model model, HttpServletRequest request){

        ArticleDetailDTO articleDetailVo =articleService.getDetailByUrl(articleUrl);
        if (articleDetailVo == null) {
            return "404";
        }
        List<ArticleRecommendDTO> articleRecommendVo=articleService.getRecommondArticle(Constant.ArticlePlace.GOOD_PAGE);
        List<Comment> comments = commentService.getCommentList(articleDetailVo.getId());
        ArticleTimeAxis pre=articleService.getPreArticle(articleDetailVo.getId());
        ArticleTimeAxis next=articleService.getNextArticle(articleDetailVo.getId());
        model.addAttribute("detail", articleDetailVo);
        model.addAttribute("recommendList",articleRecommendVo);
        model.addAttribute("commentList",comments);
        model.addAttribute("pre",pre);
        model.addAttribute("next",next);
        return "info";
    }
}
