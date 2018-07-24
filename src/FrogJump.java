
public class FrogJump {
    public int solution(int X, int Y, int D) {
    	if(X==Y) {
    		return 0;
    	}
        int distance= Y-X;
        int jumps=distance/D;
        if(distance%D !=0) {
        	int direction=(distance>=0?1:-1);
        	jumps+=direction;
        }
        return jumps;
        
    }
}
