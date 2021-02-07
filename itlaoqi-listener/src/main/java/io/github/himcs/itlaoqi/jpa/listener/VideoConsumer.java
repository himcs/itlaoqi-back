package io.github.himcs.itlaoqi.jpa.listener;

import com.rabbitmq.client.Channel;
import io.github.himcs.itlaoqi.jpa.constan.QueueConstans;
import io.github.himcs.itlaoqi.jpa.entity.Chapter;
import io.github.himcs.itlaoqi.jpa.repository.ChapterRepository;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author mcs [lik0x01@sp.noahgroup.com]
 */
@Component
@Slf4j
public class VideoConsumer {

  @Resource
  ChapterRepository chapterRepository;

  @RabbitListener(
      queues = {QueueConstans.QUEUE_VIDEO}
  )
  @SneakyThrows
  public void handleOrder(@Payload String payload, Message message, Channel channel) {
    try {
      Map<String, Object> data = new BasicJsonParser().parseMap(payload);
      String videoUrl = (String) data.get("video_url");
      if (StringUtils.isEmpty(videoUrl)) {
        return;
      }
      Optional<Chapter> chapter = chapterRepository
          .findById(Integer.valueOf((String) data.get("id")));
      chapter.get().setVideoUrl(videoUrl);
      chapter.get().setImg((String) data.get("img"));
      chapterRepository.save(chapter.get());
    } finally {
      long deliveryTag = message.getMessageProperties().getDeliveryTag();
      channel.basicAck(deliveryTag, false);
    }
  }
}
