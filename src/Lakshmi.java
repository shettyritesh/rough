
public class Lakshmi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1, 3, 2, -1, 4, -1, 3};
		int left=-1;
		int right=arr.length;
		long leftTotal=0;
		long righttotal=0;
		int result=Integer.MIN_VALUE;
		while((left+2)!=right) {
			if(leftTotal>righttotal) {
				right--;
				righttotal=arr[right]+righttotal;				
				
			}
			else if(righttotal>leftTotal) {
				left++;
				leftTotal=leftTotal+arr[left];				
			}else {
				if((left+2)==right) {
					break;
				}
				left++;
				leftTotal=leftTotal+arr[left];				
			}
		if(leftTotal==righttotal) {
			result=left+1;
		}	
		}
		if(result==Integer.MIN_VALUE) {
			System.out.println("No match found");
		}
		else {
			System.out.println("The index is"+result);
		}
	}

}
