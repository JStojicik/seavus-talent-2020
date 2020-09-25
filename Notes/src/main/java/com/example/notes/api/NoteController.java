package com.example.notes.api;

import com.example.notes.model.Note;
import com.example.notes.security.SecurityService;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@RequestMapping("/api/notes")
@RestController
public class NoteController {
    private final NoteService noteService;
    private final SecurityService securityService;

    @Autowired
    public NoteController(NoteService noteService, SecurityService securityService) {
        this.noteService = noteService;
        this.securityService = securityService;
    }

    @PostMapping
    public Note createNote(@RequestBody CreateNoteRequest request) {
        return noteService.createNote(request.title, request.content, request.tagIds, securityService.getAuthenticatedCustomer().getId());
    }

    @GetMapping("/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping({"", "/"})
    public List<Note> findNotesByUserId() { //getAllNotes
        return noteService.findNotesByUserId(securityService.getAuthenticatedCustomer().getId());
    }

    @GetMapping("/tags/{id}")
    public List<Note> findNotesByTagId(@PathVariable Long id) {
        return noteService.findNotesByTagId(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        return noteService.updateNote(request.title, request.content, id, request.tagIds);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
        public HashSet<Long> tagIds;
    }
}
