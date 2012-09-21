package res.resource;

public class Link {

	public static Link singleton = null;
		public Link() {
			if(singleton == null)
				singleton = this;
			// TODO Auto-generated constructor stub
		}
}
