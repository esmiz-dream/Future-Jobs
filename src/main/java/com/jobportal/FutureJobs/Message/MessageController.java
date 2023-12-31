package com.jobportal.FutureJobs.Message;

import com.jobportal.FutureJobs.Application.Application;
import com.jobportal.FutureJobs.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping(path = "api/v1/message")
public class MessageController {
    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<Object> getMessage(){
        return messageService.getMessages();
    }

    @GetMapping
    @RequestMapping(path = "{messageId}")
    public ResponseEntity<Object> getMessageById(@PathVariable("messageId") Long messageId){
        return messageService.getMessageById(messageId);
    }

    @GetMapping(path = "box")
    public ResponseEntity<Object> getMessageBox(@RequestParam("sender") Long sender,
                                                @RequestParam(name = "receiver") Long receiver ){
        return messageService.getMessageBox(sender, receiver);
    }

    @PostMapping
    public ResponseEntity<Object> createMessage(
            @RequestParam("fromuser") Long fromuser,
            @RequestParam("touser") Long touser,
            @RequestBody Message message){
        return messageService.createMessage(fromuser, touser,message);
    }

}

