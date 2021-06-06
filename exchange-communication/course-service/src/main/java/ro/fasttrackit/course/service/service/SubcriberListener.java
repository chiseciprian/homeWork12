package ro.fasttrackit.course.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.repository.CourseStudentRepository;
import ro.fasttrackit.model.StudentDeleteEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubcriberListener {
    private final CourseStudentRepository courseStudentRepository;

    @RabbitListener(queues = "#{fanoutQueue.name}")
    void fanoutListener(StudentDeleteEvent event) {
        log.info("Received fanout event " + event);
        courseStudentRepository.deleteAllByStudentId(event.getStudentId());
    }
}
