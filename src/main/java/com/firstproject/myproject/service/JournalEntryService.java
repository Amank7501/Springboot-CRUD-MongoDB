package com.firstproject.myproject.service;

import com.firstproject.myproject.entity.JournalEntry;
import com.firstproject.myproject.entity.User;
import com.firstproject.myproject.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e){
            log.error("Exception ", e);
        }

    }

    public void saveEntry(JournalEntry journalEntry){
        try {

            journalEntryRepository.save(journalEntry);

        } catch (Exception e){
            log.error("Exception ", e);
        }

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryByID(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
 }


//controller--->service--->repository