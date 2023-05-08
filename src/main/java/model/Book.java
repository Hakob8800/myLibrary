package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String title;
    private String description;
    private int price;
    private Author author;
    private String imagePath;
    private User user;
}
