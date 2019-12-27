import java.util.ArrayList;
import java.util.Scanner;

class State{
	ArrayList updown;
	ArrayList side;
	int num;
	public State(ArrayList updown, ArrayList side, int num) {
		this.updown = updown;
		this.side = side;
		this.num = num;
	}
}
class main_2048 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] board = new int[N][N];
		
		scan.nextLine();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				 board[i][j] = scan.nextInt();
				 
			}
			scan.nextLine();
		}
		ArrayList<ArrayList<Integer>> updown = new ArrayList<>();
		ArrayList<ArrayList<Integer>> side = new ArrayList<>();
		
		ArrayList<Integer> tmp = new ArrayList<>();
		ArrayList<Integer> tmp2 = new ArrayList<>();
		
		for(int j=0;j<N;j++) {
			tmp.clear();
			tmp2.clear();
			System.out.println();
			for(int i=0;i<N;i++) {
				tmp.add(board[i][j]);
				tmp2.add(board[j][i]);
			}
			side.add((ArrayList)tmp2.clone());
			updown.add((ArrayList)tmp.clone());
		}
		
		ArrayList<State> newStat = new ArrayList<>();
		State stat = new State(updown, side, 0);
		newStat.add(stat);
		
		ArrayList<ArrayList<Integer>> newUpdown;
		ArrayList<ArrayList<Integer>> newSide;
		ArrayList<ArrayList<Integer>> updownTemp;
		ArrayList<ArrayList<Integer>> sideTemp; 
		
		State tempStat;
		int maxNum=0;
		while(!newStat.isEmpty()) {
			
			tempStat = newStat.get(0);
			if(tempStat.num == 6) break;
			
			System.out.println("New State ) num : "+ tempStat.num);
			System.out.println();
			
			updownTemp = (ArrayList<ArrayList<Integer>>) tempStat.updown.clone();
			sideTemp = (ArrayList<ArrayList<Integer>>) tempStat.side.clone();
			/*upper*/
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-1;j++) {
					if(j+1 < updownTemp.get(i).size() && updownTemp.get(i).get(j)==updownTemp.get(i).get(j+1)) {
						((ArrayList) updownTemp.get(i)).set(j, 2*updownTemp.get(i).get(j));
						if(maxNum < 2*updownTemp.get(i).get(j)) {
							maxNum = 2*updownTemp.get(i).get(j);
						}
						updownTemp.get(i).remove(j+1);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(i >= updownTemp.get(j).size()) {
						sideTemp.get(i).set(j, 0);
					}else {
						sideTemp.get(i).set(j, updownTemp.get(j).get(i));
					}
				}
			}
			newStat.add(new State((ArrayList)updown.clone(), (ArrayList)side.clone(), tempStat.num+1));
			
			updownTemp = (ArrayList<ArrayList<Integer>>) tempStat.updown.clone();
			sideTemp = (ArrayList<ArrayList<Integer>>) tempStat.side.clone();
			/*under*/
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>0;j--) {
					if(j-1 >= 0 && updownTemp.get(i).get(j)==updownTemp.get(i).get(j-1)) {
						((ArrayList) updownTemp.get(i)).set(j, 2*updownTemp.get(i).get(j));
						if(maxNum < 2*updownTemp.get(i).get(j)) maxNum = 2*updownTemp.get(i).get(j);
						updownTemp.get(i).remove(j+1);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i >= updownTemp.get(j).size()) {
						sideTemp.get(i).set(j, 0);
					}else {
						sideTemp.get(i).set(j, updownTemp.get(j).get(i));
					}
				}
			}
			newStat.add(new State((ArrayList)updown.clone(), (ArrayList)side.clone(), tempStat.num+1));
			
			updownTemp = (ArrayList<ArrayList<Integer>>) tempStat.updown.clone();
			sideTemp = (ArrayList<ArrayList<Integer>>) tempStat.side.clone();
			/*rigth*/
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-1;j++) {
					if(j+1 < sideTemp.get(i).size() && sideTemp.get(i).get(j)==sideTemp.get(i).get(j+1)) {
						((ArrayList) sideTemp.get(i)).set(j, 2*sideTemp.get(i).get(j));
						if(maxNum < 2*sideTemp.get(i).get(j)) maxNum = 2*sideTemp.get(i).get(j);
						sideTemp.get(i).remove(j+1);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i >= sideTemp.get(j).size()) {
						updownTemp.get(i).set(j, 0);
					}else {
						updownTemp.get(i).set(j, sideTemp.get(j).get(i));
					}
				}
			}
			newStat.add(new State((ArrayList)updown.clone(), (ArrayList)side.clone(), tempStat.num+1));
			
			updownTemp = (ArrayList<ArrayList<Integer>>) tempStat.updown.clone();
			sideTemp = (ArrayList<ArrayList<Integer>>) tempStat.side.clone();
			
			/*left*/
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>0;j--) {
					if(j-1 >= 0 && sideTemp.get(i).get(j)==sideTemp.get(i).get(j-1)) {
						((ArrayList) sideTemp.get(i)).set(j, 2*sideTemp.get(i).get(j));
						if(maxNum < 2*sideTemp.get(i).get(j)) maxNum = 2*sideTemp.get(i).get(j);
						sideTemp.get(i).remove(j+1);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i >= sideTemp.get(j).size()) {
						updownTemp.get(i).set(j, 0);
					}else {
						updownTemp.get(i).set(j, sideTemp.get(j).get(i));
					}
				}
			}
			newStat.add(new State((ArrayList)updown.clone(), (ArrayList)side.clone(), tempStat.num+1));
			newStat.remove(0);
		}
		System.out.println(maxNum);
	}

}
