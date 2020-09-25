package com.example.notes.service;

import com.example.notes.model.Tag;
import com.example.notes.model.User;
import com.example.notes.repository.TagRepository;
import com.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    public TagService(TagRepository tagRepository, UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }

    public Tag createTag(String name, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        Tag tag = new Tag(name, user);
        tagRepository.save(tag);
        return tag;
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findTags(Long userId) {
        return tagRepository.findTagsByUserId(userId);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
