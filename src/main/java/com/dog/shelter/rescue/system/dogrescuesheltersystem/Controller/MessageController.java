package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.MessageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Message;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Long senderId, Long receiverId, String type,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd,
                       Integer status){

        log.info("Querying message of page: {}, pageSize: {}, senderId : {}, receiverId: {}, type: {}, dateStart: {}, dateEnd: {}, status: {}",
                page, pageSize, senderId, receiverId, type, dateStart, dateEnd, status);

        return Result.success(messageService.page(
                page, pageSize, senderId, receiverId, type, dateStart, dateEnd, status
        ));
    }

    @PostMapping("/read/{messageId}")
    public Result read(@PathVariable Long messageId){
        log.info("Read message with id : {}", messageId);
        messageService.read(messageId);
        return Result.success();
    }

    @DeleteMapping("/delete/{ids}")
    public Result delete(@PathVariable List<Long> ids){
        log.info("Deleting message with id: {}", ids);
        messageService.delete(ids);
        return Result.success();
    }


}


