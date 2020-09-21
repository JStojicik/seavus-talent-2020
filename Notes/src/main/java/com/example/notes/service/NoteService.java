package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(String title, String content) {
        Note note = new Note(title, content);
        noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(String title, String content, Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
