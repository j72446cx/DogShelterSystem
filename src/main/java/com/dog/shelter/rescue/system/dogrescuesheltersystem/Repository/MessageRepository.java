package com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Message;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.MessagePageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MessageRepository {

    List<Message> findByReceiver(Long receiver);

    void save(Message message);

    List<Message> page(Integer page, Integer pageSize, Long senderId, Long receiverId, String type, LocalDate dateStart, LocalDate dateEnd, Integer status);

    void read(Long messageId);

    void delete(List<Long> ids);
}
