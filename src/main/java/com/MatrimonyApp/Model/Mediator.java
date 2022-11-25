package com.MatrimonyApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "interaction")
public class Mediator {

	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
	private int id;
	
	private String sender;
	private String sendertype;
	private String sendercontact;
	private String request;
	private String receiver;
	private String receivertype;
	private String receivercontact;
	private String responce;
	private String mediatoraction;
	public Mediator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mediator(int id, String sender, String sendertype, String sendercontact, String request, String receiver,
			String receivertype, String receivercontact, String responce, String mediatoraction) {
		super();
		this.id = id;
		this.sender = sender;
		this.sendertype = sendertype;
		this.sendercontact = sendercontact;
		this.request = request;
		this.receiver = receiver;
		this.receivertype = receivertype;
		this.receivercontact = receivercontact;
		this.responce = responce;
		this.mediatoraction = mediatoraction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSendertype() {
		return sendertype;
	}
	public void setSendertype(String sendertype) {
		this.sendertype = sendertype;
	}
	public String getSendercontact() {
		return sendercontact;
	}
	public void setSendercontact(String sendercontact) {
		this.sendercontact = sendercontact;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceivertype() {
		return receivertype;
	}
	public void setReceivertype(String receivertype) {
		this.receivertype = receivertype;
	}
	public String getReceivercontact() {
		return receivercontact;
	}
	public void setReceivercontact(String receivercontact) {
		this.receivercontact = receivercontact;
	}
	public String getResponce() {
		return responce;
	}
	public void setResponce(String responce) {
		this.responce = responce;
	}
	public String getMediatoraction() {
		return mediatoraction;
	}
	public void setMediatoraction(String mediatoraction) {
		this.mediatoraction = mediatoraction;
	}
	
	
}
