package Entities;

import java.io.Serializable;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	@EmbeddedId
	private MessageId messageId;
	private String text;
	
	@ManyToOne
	@JoinColumn(name="idSender",referencedColumnName="id",updatable=false,insertable=false)
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name="idReceiver",referencedColumnName="id",updatable=false,insertable=false)
	private User userReceiver;
	
	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public Message(String text, User userSender, User userReceiver) {
		super();
		this.messageId= new MessageId(userSender.getId(), userReceiver.getId());
		this.text = text;
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
   
}
