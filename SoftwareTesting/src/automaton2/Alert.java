package automaton2;

public class Alert {
	public Integer icon = null;
	public String heading = null;
	public String description = null;
	public String image = null;
	public Integer price = null;
	public String linkToProduct = null;
	
	public boolean alertContainsValidProperties() {
		if (this.icon != null && this.heading != null && this.heading != null &&
				this.heading != null && this.heading != null) {
			return true;
		}
		return false;
	}
	
	public Alert(Integer icon, String heading, String description, String image, Integer price, String linkToProduct) {
		this.icon = icon;
		this.heading = heading;
		this.description = description;
		this.image = image;
		this.price = price;
		this.linkToProduct = linkToProduct;
	}
}
