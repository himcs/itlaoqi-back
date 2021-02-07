package io.github.himcs.itlaoqi.jpa.controller;


import io.github.himcs.itlaoqi.jpa.common.web.JsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mcs [787632628@qq.com]
 */
@RestController
public class ChapterController {

  @RequestMapping("/")
  public JsonResponse all() {
    return JsonResponse.OK();
  }
}
