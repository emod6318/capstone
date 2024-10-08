package com.example.capstone.dto;
import com.example.capstone.entity.TodoEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDTO {
    private Long id;
    public String memberEmail;
    private String todoTitle;
    private String todoCategory;
    private String todoStart;
    private String todoEnd;
    private String todoContent;

    // Entity -> DTO 변환하는 메서드.
//    public static TodoDTO toTodoDTO(TodoEntity todoEntity) {
//        TodoDTO toTodoDTO = new TodoDTO();
//        toTodoDTO.setId(todoEntity.getId());
//        toTodoDTO.setMemberEmail(todoEntity.getMemberEmail());
//        toTodoDTO.setTodoTitle(todoEntity.getTodoTitle());
//        toTodoDTO.setTodoCategory(todoEntity.getTodoCategory());
//        toTodoDTO.setTodoStart(todoEntity.getTodoStart());
//        toTodoDTO.setTodoEnd(todoEntity.getTodoEnd());
//        toTodoDTO.setTodoContent(todoEntity.getTodoContent());
//        return toTodoDTO;
//    }
}
