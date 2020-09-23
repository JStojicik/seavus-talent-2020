package com.example.notes.api;

import com.example.notes.model.Tag;
import com.example.notes.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/tags")
    public void createTag(@RequestBody TagController.CreateTagRequest request) {
        tagService.createTag(request.name, request.userId);
    }

    @GetMapping({"/tags", "/tags/"})
    public List<Tag> findAllTags() {
        return tagService.findTags();
    }

    @GetMapping("/tags/{id}")
    public Tag findTagById(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

    static class CreateTagRequest {
        public String name;
        public Long userId;
    }
}
