package com.example.noteswithoutdatabse.api;

import com.example.noteswithoutdatabse.model.Note;
import com.example.noteswithoutdatabse.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/api")
@RestController
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request.title, request.content);
    }

    @GetMapping("/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping({"/notes", "/notes/"})
    public List<Note> findNotes() {
        return noteService.findNotes();
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {
        Note note = noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        note.setTitle(request.title);
        note.setContent(request.content);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
    }
}
