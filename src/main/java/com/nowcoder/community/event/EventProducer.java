package com.nowcoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 处理事件（发布消息）
    public void fireEvent(Event event) {
        // 将事件发布到指定的主题
        // 事件对象--> JSON字符串
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
