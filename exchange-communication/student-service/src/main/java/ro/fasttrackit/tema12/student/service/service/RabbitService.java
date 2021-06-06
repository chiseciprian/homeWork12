package ro.fasttrackit.tema12.student.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.model.StudentDeleteEvent;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public void notifyDeleteStudent(String studentId) {
        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                studentId,
                new StudentDeleteEvent(studentId));
    }
}
