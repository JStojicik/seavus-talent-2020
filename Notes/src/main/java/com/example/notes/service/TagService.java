package com.example.notes.service;

import com.example.notes.model.Tag;
import com.example.notes.model.User;
import com.example.notes.repository.NoteRepository;
import com.example.notes.repository.TagRepository;
import com.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public TagService(TagRepository tagRepository, UserRepository userRepository, NoteRepository noteRepository) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    public Tag createTag(String name, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        Tag tag = new Tag(name, user);
        tagRepository.save(tag);
        return tag;
    }

    public Tag updateTag(String name, Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        tag.setName(name);
        tagRepository.save(tag);
        return tag;
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findTags(Long userId) {
        return tagRepository.findTagsByUserId(userId);
    }

    @Transactional
    public void deleteTag(Long id) {
        noteRepository.findNotesByTagsId(id).forEach(note -> note.removeTag(id));
        tagRepository.deleteById(id);
    }

}
