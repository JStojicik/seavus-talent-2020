package com.example.noteswithoutdatabse.repository;

import com.example.noteswithoutdatabse.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {
    private long nextId = 1;

    private ArrayList<Note> notes = new ArrayList<>();

    public void save(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public List<Note> findAll() {
        return notes;
    }

    public void deleteNoteById(Long id) {
        notes.remove(findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
