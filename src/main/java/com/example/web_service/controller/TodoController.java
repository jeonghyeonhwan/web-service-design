package com.example.web_service.controller;

import com.example.web_service.db.ApiResponse;
import com.example.web_service.model.Todo;
import com.example.web_service.service.TodoService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // =============== POST 2개 =====================

    // 1) Todo 생성
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestParam String title) {
        Todo t = service.create(title);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(t, "Todo created"));
    }

    // 2) Todo 여러 개 생성
    @PostMapping("/bulk")
    public ResponseEntity<?> bulkCreate(@RequestBody List<String> titles) {
        if (titles == null || titles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Title list cannot be empty"));
        }
        List<Todo> list = new ArrayList<>();
        for (String title : titles) list.add(service.create(title));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(list, "Bulk creation success"));
    }

    // =============== GET 2개 =====================

    // 3) Todo 전체 조회
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ApiResponse.success(service.getAll(), "Fetch all"));
    }

    // 4) Todo 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Todo t = service.get(id);
        if (t == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Todo not found"));

        return ResponseEntity.ok(ApiResponse.success(t, "Fetch success"));
    }

    // =============== PUT 2개 =====================

    // 5) Todo 완료/미완료 토글
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id) {
        Todo t = service.update(id, "toggle");
        if (t == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Todo not found"));

        return ResponseEntity.ok(ApiResponse.success(t, "Updated"));
    }

    // 6) Todo 제목 변경 (예시)
    @PutMapping("/{id}/rename")
    public ResponseEntity<?> renameTodo(@PathVariable Long id, @RequestParam String newTitle) {
        Todo t = service.get(id);
        if (t == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Todo not found"));

        t.setCompleted(false);
        return ResponseEntity.ok(ApiResponse.success(t, "Renamed"));
    }

    // =============== DELETE 2개 =====================

    // 7) 단일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        if (!service.delete(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Todo not found"));

        return ResponseEntity.ok(ApiResponse.success(null, "Deleted"));
    }

    // 8) 전체 삭제
    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAll() {
        service.getAll().forEach(t -> service.delete(t.getId()));
        return ResponseEntity.ok(ApiResponse.success(null, "All deleted"));
    }
}
