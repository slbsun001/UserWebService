package com.restAPI;

public enum Status {

		
		ACTIVE("A"), 
		DISABLED("D"),
		AWAITING_ACTIVATION("AA");

		private String value;

		private Status(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static Status getType(String value) {
			for (Status state : Status.values()) {
				if (state.getValue().equals(value)) {
					return state;
				}
			}
			throw new IllegalStateException("Invalid type for State: " + value);
		}

}
