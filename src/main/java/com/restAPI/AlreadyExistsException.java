package com.restAPI;


public class AlreadyExistsException extends ApplicationException {

		private static final long serialVersionUID = 1L;

		public AlreadyExistsException(String message, ClientMessage clientMessage) {
			super(message, clientMessage);
		}

		public AlreadyExistsException(String message, ClientMessage clientMessage, Throwable cause) {
			super(message, clientMessage, cause);
		}

		public AlreadyExistsException(ClientMessage clientMessage, Throwable cause) {
			super(clientMessage, cause);
		}

}

