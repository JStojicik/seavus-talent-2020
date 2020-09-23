package com.example.notes.service;

import com.example.notes.model.Tag;
import com.example.notes.model.User;
import com.example.notes.repository.TagRepository;
import com.example.notes.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void createTag(String name, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Tag tag = new Tag(name, user);
        tagRepository.save(tag);
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findTags() {
        return tagRepository.findAll();
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
