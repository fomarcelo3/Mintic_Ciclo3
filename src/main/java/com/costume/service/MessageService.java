package com.costume.service;

import com.costume.model.Message;
import com.costume.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio entidad message
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> unMensaje = messageRepository.getMessage(message.getIdMessage());
            if (unMensaje.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public  Message update(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> message_bd = messageRepository.getMessage(message.getIdMessage());

            if (!message_bd.isEmpty()){
                if (message.getMessageText() != null){
                    message_bd.get().setMessageText(message.getMessageText());
                }

                messageRepository.save(message_bd.get());
                return message_bd.get();
            }
        }

        return  message;
    }


    public boolean deleteMessage(int id){
        Optional<Message>  message = messageRepository.getMessage(id);
        if (message.isEmpty()){
            return  false;
        }else {
            messageRepository.delete(message.get());
            return  true;
        }
    }
}
