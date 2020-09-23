package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.model.User;
import com.example.notes.repository.NoteRepository;
import com.example.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public void createNote(String title, String content, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Note note = new Note(title, content, user);
        noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotesByTagId(Long id) {
        return noteRepository.findNotesByTagsId(id);
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
