/*
 * Copyright (C) 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.himcs.itlaoqi.jpa.common.web;

/**
 * @author xiaolongzuo
 */
public class JsonResponse {

  public static final String OK_CODE = "200";
  public static final String DEFAULT_MESSAGE = "OK";
  public static final String FAIL_CODE = "200";
  private String code;
  private String message;
  private Object data;

  public JsonResponse(String code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static JsonResponse OK(String message, Object data) {
    return new JsonResponse(OK_CODE, message, data);
  }


  public static JsonResponse OK(Object data) {
    return new JsonResponse(OK_CODE, DEFAULT_MESSAGE, data);
  }


  public static JsonResponse OK() {
    return new JsonResponse(OK_CODE, DEFAULT_MESSAGE, null);
  }


  public static JsonResponse FAIL(String message, Object data) {
    return new JsonResponse(FAIL_CODE, message, data);
  }


  public static JsonResponse FAIL(Object data) {
    return new JsonResponse(FAIL_CODE, DEFAULT_MESSAGE, data);
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public Object getData() {
    return data;
  }

}
