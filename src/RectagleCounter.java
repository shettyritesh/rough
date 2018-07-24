import java.awt.Point;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class RectagleCounter{
	int[][] arr;
	public RectagleCounter(int[][] arr1) {
		arr=arr1;
	}
	static Comparator<Point> comparator= new Comparator<Point>() {
		public int compare(Point one, Point two)
		{
			if(one.getX()==two.getX() && one.getY()==two.getY()) {
				return 0;
			}
			if(one.getX()==two.getX()) {
				return (int)one.getY()-(int)two.getY();
			}
			else {
				return (int)one.getX()-(int)two.getX();
			}
		}};

	Map<Point,Point> hLTR=new TreeMap<Point,Point>(comparator);
	Map<Point,Point> hRTL=new TreeMap<Point,Point>(comparator);
	Map<Point,Point> vTTB=new TreeMap<Point,Point>(comparator);
	Map<Point,Point> vBTT=new TreeMap<Point,Point>(comparator);
	public void printRectangleCordinates(){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				if(arr[row][col]==0){
					continue;
				}
				Point prevpoint=null;
				if((col-1)>=0){
					prevpoint=new Point(row,col-1);
				}
				Point start=null;
				if(prevpoint!=null) {
					start= hRTL.get(prevpoint);
				}
				Point currpoint= new Point(row,col);
				if(start==null){
					 start=currpoint;
				}
				hRTL.remove(prevpoint);				
				hRTL.put(currpoint,start);
				hLTR.put(start,currpoint);				
				
				prevpoint=null;
				if((row-1)>=0){
					prevpoint= new Point(row-1,col);
				}
				if(prevpoint!=null) {
					start= vBTT.get(prevpoint);
					vBTT.remove(prevpoint);					
				}
				
				if(start==null){
					 start=currpoint;
				}				
				vTTB.put(start,currpoint);
				vBTT.put(currpoint,start);
				

			}
		
		
		}
		getRectangles();

	}
	
	private void getRectangles(){
		for(Point point: hLTR.keySet()){
			Point hltrEnd=hLTR.get(point);
			Point vTTBend=vTTB.get(hltrEnd);
			if(vTTBend==null) {
				System.out.println(point.getX()+","+point.getY() +"-->"+hltrEnd.getX()+","+hltrEnd.getY());
				continue;
			}
			Point hrtlend=hRTL.get(vTTBend);
			Point vbttend= vBTT.get(hrtlend);
			
			if (point.equals(vbttend)){
				System.out.println(point.getX()+","+point.getY() +"-->"+vTTBend.getX()+","+vTTBend.getY());
			}
		
		}
	}


}