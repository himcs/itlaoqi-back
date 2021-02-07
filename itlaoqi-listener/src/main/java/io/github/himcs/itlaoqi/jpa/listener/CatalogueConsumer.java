package io.github.himcs.itlaoqi.jpa.listener;

import com.rabbitmq.client.Channel;
import io.github.himcs.itlaoqi.jpa.constan.QueueConstans;
import io.github.himcs.itlaoqi.jpa.entity.Catalogue;
import io.github.himcs.itlaoqi.jpa.repository.CatalogueRepository;
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
 * @author mcs [787632628@qq.com]
 */
@Component
@Slf4j
public class CatalogueConsumer {

  @Resource
  CatalogueRepository catalogueRepository;

  @RabbitListener(
      queues = {QueueConstans.QUEUE_CATALOGUE}
  )
  @SneakyThrows
  public void handleOrder(@Payload String payload, Message message, Channel channel) {
    try {
      Map<String, Object> data = new BasicJsonParser().parseMap(payload);
      log.info("目录数据 {}", data);
      Catalogue catalogue = new Catalogue();
      catalogue.setName((String) data.get("name"));
      catalogue.setUrl((String) data.get("url"));
      catalogue.setImg((String) data.get("img"));
      catalogueRepository.save(catalogue);
    } finally {
      long deliveryTag = message.getMessageProperties().getDeliveryTag();
      channel.basicAck(deliveryTag, false);
    }
  }
}
