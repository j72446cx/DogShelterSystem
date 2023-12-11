package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Message;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.MessagePageBean;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {

    public void saveMessage(Message message);

    public List<Message> getMessagesForReceiver(Long receiver);

    MessagePageBean page(Integer page, Integer pageSize, Long senderId, Long receiverId, String type, LocalDate dateStart, LocalDate dateEnd, Integer status);

    void read(Long messageId);

    void delete(List<Long> ids);


    MessagePageBean pageUser(Integer page, Integer pageSize, Long senderId, Long receiverId, String type, LocalDate dateStart, LocalDate dateEnd, Integer status);

    void readUser(Long messageId);

    void deleteUser(List<Long> ids);

    public void saveMessageUser(Message message);

    public List<Message> getMessagesForReceiverUser(Long receiver);
}
