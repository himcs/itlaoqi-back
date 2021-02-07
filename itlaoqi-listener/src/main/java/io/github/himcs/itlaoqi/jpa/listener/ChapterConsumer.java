package io.github.himcs.itlaoqi.jpa.listener;

import com.rabbitmq.client.Channel;
import io.github.himcs.itlaoqi.jpa.constan.QueueConstans;
import io.github.himcs.itlaoqi.jpa.entity.Chapter;
import io.github.himcs.itlaoqi.jpa.repository.ChapterRepository;
import java.util.Map;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author mcs [lik0x01@sp.noahgroup.com]
 */
@Component
@Slf4j
public class ChapterConsumer {

  @Resource
  ChapterRepository chapterRepository;

  @RabbitListener(
      queues = {QueueConstans.QUEUE_CHAPTER}
  )
  @SneakyThrows
  public void handleOrder(@Payload String payload, Message message, Channel channel) {
    try {
      Map<String, Object> data = new BasicJsonParser().parseMap(payload);
      log.info("详情数据 {}", data);
      Chapter chapter = new Chapter();
      chapter.setName((String) data.get("name"));
      chapter.setUrl((String) data.get("url"));
      chapter.setSort(Integer.valueOf((String) data.get("sort")));
      chapter.setTime(Integer.valueOf((String) data.get("time")));
      chapter.setCid(Integer.valueOf((String) data.get("cid")));
      chapterRepository.save(chapter);
    } finally {
      long deliveryTag = message.getMessageProperties().getDeliveryTag();
      channel.basicAck(deliveryTag, false);
    }
  }
}
