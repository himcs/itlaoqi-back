package io.github.himcs.itlaoqi.jpa.config;

import io.github.himcs.itlaoqi.jpa.constan.ExchangeConstans;
import io.github.himcs.itlaoqi.jpa.constan.QueueConstans;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mcs [787632628@qq.com]
 */
@Configuration
public class RabbitMQConfiguration {

  @Bean(ExchangeConstans.EXCAHNGE_CATALOGUE)
  FanoutExchange exchange() {
    return new FanoutExchange(ExchangeConstans.EXCAHNGE_CATALOGUE, true, false);
  }

  @Bean(QueueConstans.QUEUE_CATALOGUE)
  Queue queue() {
    return new Queue(QueueConstans.QUEUE_CATALOGUE, true);
  }

  @Bean
  Binding binding(@Qualifier(QueueConstans.QUEUE_CATALOGUE) Queue queue,
      @Qualifier(ExchangeConstans.EXCAHNGE_CATALOGUE) FanoutExchange exchange) {

    return BindingBuilder.bind(queue).to(exchange);
  }


  @Bean(ExchangeConstans.EXCAHNGE_CHAPTER)
  FanoutExchange exchangeCHAPTER() {
    return new FanoutExchange(ExchangeConstans.EXCAHNGE_CHAPTER, true, false);
  }

  @Bean(QueueConstans.QUEUE_CHAPTER)
  Queue queueCHAPTER() {
    return new Queue(QueueConstans.QUEUE_CHAPTER, true);
  }

  @Bean
  Binding bindingCHAPTER(@Qualifier(QueueConstans.QUEUE_CHAPTER) Queue queue,
      @Qualifier(ExchangeConstans.EXCAHNGE_CHAPTER) FanoutExchange exchange) {

    return BindingBuilder.bind(queue).to(exchange);
  }

  @Bean(ExchangeConstans.EXCAHNGE_VIDEO)
  FanoutExchange exchangeVIDEO() {
    return new FanoutExchange(ExchangeConstans.EXCAHNGE_VIDEO, true, false);
  }

  @Bean(QueueConstans.QUEUE_VIDEO)
  Queue queueVIDEO() {
    return new Queue(QueueConstans.QUEUE_VIDEO, true);
  }

  @Bean
  Binding bindingVIDEO(@Qualifier(QueueConstans.QUEUE_VIDEO) Queue queue,
      @Qualifier(ExchangeConstans.EXCAHNGE_VIDEO) FanoutExchange exchange) {

    return BindingBuilder.bind(queue).to(exchange);
  }
}
