package com.demo.user.model;

public class UserModel {
	  private Long id;
	    private String name;
	    private String email;
	    private String mobile;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public UserModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserModel(Long id, String name, String email, String mobile) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
		}
		@Override
		public String toString() {
			return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
		}

		
}
