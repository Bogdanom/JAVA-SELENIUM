package opencart.data.repository;

interface IEmail {
	IPassword setEmail(String email);
}
interface IPassword {
	IBuildUser setPassword(String password);
}
interface IBuildUser {
	IUser build();
}
public class User implements IEmail, IPassword, IBuildUser, IUser {
	private String email;
	private String password;

	private User() {
}
	public static IEmail getUser() {
		return new User();
	}
	public IPassword setEmail(String email) {
		this.email = email;
		return this;
	}
	public IBuildUser setPassword(String password) {
		this.password = password;
		return this;
	}	
	public IUser build() {
		return this;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "User [password=" + password	+ ", email=" + email + "]";
	}
}
