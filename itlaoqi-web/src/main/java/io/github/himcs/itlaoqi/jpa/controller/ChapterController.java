package io.github.himcs.itlaoqi.jpa.controller;


import io.github.himcs.itlaoqi.jpa.common.web.JsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mcs [lik0x01@sp.noahgroup.com]
 */
@RestController
public class ChapterController {

  @RequestMapping("/")
  public JsonResponse all() {
    return JsonResponse.OK();
  }
}
