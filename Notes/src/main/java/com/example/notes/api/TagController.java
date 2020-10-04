package com.example.notes.api;

import com.example.notes.model.Tag;
import com.example.notes.security.SecurityService;
import com.example.notes.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagService;
    private final SecurityService securityService;

    public TagController(TagService tagService, SecurityService securityService) {
        this.tagService = tagService;
        this.securityService = securityService;
    }

    @PostMapping
    public Tag createTag(@RequestBody CreateTagRequest request) {
        return tagService.createTag(request.name, securityService.getAuthenticatedUser().getId());
    }

    @PutMapping("/{tagId}")
    public Tag updateTag(@PathVariable Long tagId, @RequestBody CreateTagRequest request) {
        return tagService.updateTag(request.name, tagId);
    }

    @GetMapping({"", "/"})
    public List<Tag> findTagsByUserId() {
        return tagService.findTags(securityService.getAuthenticatedUser().getId());
    }

    @GetMapping("/{id}")
    public Tag findTagById(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

    static class CreateTagRequest {
        public String name;
    }

}
