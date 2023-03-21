package multi;

public class MailVO {
	private String no;
	private String sender;
	private String title;
	private String content;
	private String date;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MailVO [no=" + no + ", sender=" + sender + ", title=" + title + ", content=" + content + ", date="
				+ date + "]";
	}

	

}
