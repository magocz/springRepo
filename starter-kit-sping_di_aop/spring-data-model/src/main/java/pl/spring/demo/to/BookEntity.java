package pl.spring.demo.to;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookEntity implements IdAware {

	private Long id;
	private String title;
	private List<AthorTo> authors = new ArrayList<AthorTo>();

	public BookEntity(Long id, String title, String... authorsList) {
		this.id = id;
		this.title = title;
		addAuthors(Arrays.asList((authorsList)));
	}

	private void addAuthors(List<String> authorsList) {
		for (String athor : authorsList) {
			authors.add(new AthorTo(athor));
		}
	}

	public BookEntity(BookTo bookTo) {
		this.id = bookTo.getId();
		this.title = bookTo.getTitle();
		this.authors.add(new AthorTo(bookTo.getAuthors()));
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAthor() {
		String authors = new String();
		for (AthorTo athorTo : this.authors) {
			authors += athorTo.toString();
		}
		return authors;
	}

	public void setId(Long nextBookId) {
		this.id = nextBookId;
	}

}
