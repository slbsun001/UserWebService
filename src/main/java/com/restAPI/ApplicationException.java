package com.restAPI;

@javax.ejb.ApplicationException(rollback = true)
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected ClientMessage clientMessage;

	public ApplicationException(String message, ClientMessage clientMessage) {
		super(message);
		this.clientMessage = clientMessage;
	}

	public ApplicationException(String message, ClientMessage clientMessage, Throwable cause) {
		super(message, cause);
		this.clientMessage = clientMessage;
	}

	public ApplicationException(ClientMessage clientMessage, Throwable cause) {
		super(cause);
		this.clientMessage = clientMessage;
	}

	public ClientMessage getClientMessage() {
		return clientMessage;
	}

}
