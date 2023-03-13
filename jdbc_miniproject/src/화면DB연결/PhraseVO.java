package 화면DB연결;

public class PhraseVO {
	private int no;
	private String id;
	private String title;
	private int book;
	private String content;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PhraseVO [no=" + no + ", id=" + id + ", title=" + title + ", book=" + book + ", content=" + content
				+ "]";
	}

	
}
