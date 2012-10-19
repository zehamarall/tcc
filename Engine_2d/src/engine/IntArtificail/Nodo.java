package engine.IntArtificail;


public class Nodo{
	Nodo pai;
	short x;
	short y;
	double energia;
	double euristica;
	
	public Nodo(Nodo pai,short x,short y, double _energia) {
		// TODO Auto-generated constructor stub
		this.pai = pai;
		this.x = x;
		this.y = y;
		energia = _energia;
	}
	
	public void set(Nodo _pai,short _x,short _y, double _energia){
		
		pai =_pai;
		x = _x;
		y = _y;
		energia = _energia;
	}
	public short getx() {
		
		return this.x;
	}
public short gety() {
		
		return this.y;
	}
}