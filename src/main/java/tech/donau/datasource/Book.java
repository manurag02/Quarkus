package tech.donau.datasource;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends PanacheEntity {
	private String name;
	private String author;

	public static List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return findAll().list();
	}
}
