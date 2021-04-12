import javafx.beans.property.SimpleStringProperty;

public class Bean {

	private SimpleStringProperty text1 = new SimpleStringProperty();
	private SimpleStringProperty text2 = new SimpleStringProperty();

	public String getText1() {
		return text1.get();
	}

	public SimpleStringProperty text1Property() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1.set(text1);
	}

	public String getText2() {
		return text2.get();
	}

	public SimpleStringProperty text2Property() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2.set(text2);
	}
}