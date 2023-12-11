package com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.Impl;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.MessageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.MessageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Message;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.MessagePageBean;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Staff;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.StaffPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void saveMessageUser(Message message) {
        messageRepository.saveUser(message);
    }

    @Override
    public List<Message> getMessagesForReceiverUser(Long receiver) {
        return messageRepository.findByReceiverUser(receiver);
    }

    @Override
    public MessagePageBean page(Integer page, Integer pageSize, Long senderId, Long receiverId, String type, LocalDate dateStart, LocalDate dateEnd, Integer status) {
        PageHelper.startPage(page, pageSize);
        List<Message> messageList = messageRepository.page(page, pageSize, senderId, receiverId, type, dateStart, dateEnd, status);
        Page<Message> messagePage = (Page<Message>) messageList;

        return new MessagePageBean(messagePage.getTotal(), messagePage.getResult());
    }

    @Override
    public MessagePageBean pageUser(Integer page, Integer pageSize, Long senderId, Long receiverId, String type, LocalDate dateStart, LocalDate dateEnd, Integer status) {
        PageHelper.startPage(page, pageSize);
        List<Message> messageList = messageRepository.pageUser(page, pageSize, senderId, receiverId, type, dateStart, dateEnd, status);
        Page<Message> messagePage = (Page<Message>) messageList;

        return new MessagePageBean(messagePage.getTotal(), messagePage.getResult());
    }

    @Override
    public List<Message> getMessagesForReceiver(Long receiver) {
        return messageRepository.findByReceiver(receiver);
    }

    @Override
    public void readUser(Long messageId) {
        messageRepository.readUser(messageId);
    }

    @Override
    public void read(Long messageId) {
        messageRepository.read(messageId);
    }

    @Override
    public void delete(List<Long> ids) {
        messageRepository.delete(ids);
    }

    @Override
    public void deleteUser(List<Long> ids) {
        messageRepository.deleteUser(ids);
    }
}
