package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.model.Tag;
import com.example.notes.model.User;
import com.example.notes.repository.NoteRepository;
import com.example.notes.repository.TagRepository;
import com.example.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    public Note createNote(String title, String content, Set<Long> tagIds, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        List<Tag> tagsList = new ArrayList<>();
        tagIds.forEach(t -> tagsList.add(tagRepository.findById(t).get()));
        Note note = new Note(title, content, user, tagsList);
        noteRepository.save(note);
        return note;
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotesByTagId(Long tagId) {
        return noteRepository.findNotesByTagsId(tagId);
    }

    public List<Note> findNotesByUserId(Long userId) {
        return noteRepository.findNotesByUserId(userId);
    }

    public Note updateNote(String title, String content, Long noteId, Set<Long> tagIds) {
        Note note = noteRepository.findById(noteId).orElseThrow(IllegalArgumentException::new);
        List<Tag> tagsList = new ArrayList<>();
        tagIds.forEach(t -> tagsList.add(tagRepository.findById(t).get()));
        note.setTags(tagsList);
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
        return note;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
