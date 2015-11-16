package ie.cit.assignment1;

import java.util.Date;

public class Comment {
	private String comment;
	private String user;
	private Date date;
	private Date time;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time2) {
		this.time = time2;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
