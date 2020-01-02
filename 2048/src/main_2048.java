import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

class main_2048 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] board = new int[N][N];

		scan.nextLine();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = scan.nextInt();

			}
			scan.nextLine();
		}

		LinkedHashMap<int[][], Integer> state = new LinkedHashMap<>();
		state.put(board, 0);

		int[][] tempState = new int[N][N];
		int[][] newState;
		
		int next;
		int maxNum = 0;
		
		for (Iterator it = state.keySet().iterator(); it.hasNext();) {
			
			newState = ((int[][]) it.next());
			int num = (int) state.get(newState);
			if(num==5) break;
			
			
			tempState = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempState[i][j] = newState[i][j];
				}
			}
			/* 위로 이동 */
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (maxNum < tempState[i][j])
						maxNum = tempState[i][j];
					next = -1;

					for (int k = i + 1; k < N; k++) {
						if (tempState[k][j] != 0) {
							next = k;
							break;
						}
					}
					if (tempState[i][j] == 0 && next != -1) {
						tempState[i][j] = tempState[next][j];
						tempState[next][j] = 0;
						next = i + 1;
						for (int k = next; k < N; k++) {
							if (tempState[k][j] != 0) {
								next = k;
								break;
							}
						}
					}
					if (next != -1 && tempState[i][j] != 0 && tempState[i][j] == tempState[next][j]) {
						tempState[i][j] = tempState[i][j] * 2;
						if (maxNum < tempState[i][j])
							maxNum = tempState[i][j];
						tempState[next][j] = 0;
					}
				}
			}
			state.put(tempState, num+1);
			tempState = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempState[i][j] = newState[i][j];
				}
			}

			/* 아래로 이동 */
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					if (maxNum < tempState[i][j])
						maxNum = tempState[i][j];
					next = -1;

					for (int k = i - 1; k >= 0; k--) {
						if (tempState[k][j] != 0) {
							next = k;
							break;
						}
					}
					if (tempState[i][j] == 0 && next != -1) {
						tempState[i][j] = tempState[next][j];
						tempState[next][j] = 0;
						next = i - 1;
						for (int k = next; k >= 0; k--) {
							if (tempState[k][j] != 0) {
								next = k;
								break;
							}
						}
					}
					if (next != -1 && tempState[i][j] != 0 && tempState[i][j] == tempState[next][j]) {
						tempState[i][j] = tempState[i][j] * 2;
						if (maxNum < tempState[i][j])
							maxNum = tempState[i][j];
						tempState[next][j] = 0;
					}
				}
			}
			state.put(tempState, num+1);
			tempState = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempState[i][j] = newState[i][j];
				}
			}
			
			/* 오른쪽으로 이동 */
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if (maxNum < tempState[i][j])
						maxNum = tempState[i][j];
					next = -1;

					for (int k = j - 1; k >= 0; k--) {
						if (tempState[i][k] != 0) {
							next = k;
							break;
						}
					}
					if (tempState[i][j] == 0 && next != -1) {
						tempState[i][j] = tempState[i][next];
						tempState[i][next] = 0;
						next = j - 1;
						for (int k = next; k >= 0; k--) {
							if (tempState[i][k] != 0) {
								next = k;
								break;
							}
						}
					}
					if (next != -1 && tempState[i][j] != 0 && tempState[i][j] == tempState[i][next]) {
						tempState[i][j] = tempState[i][j] * 2;
						if (maxNum < tempState[i][j])
							maxNum = tempState[i][j];
						tempState[i][next] = 0;
					}
				}
			}
			state.put(tempState, num+1);
			tempState = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempState[i][j] = newState[i][j];
				}
			}
			/* 왼쪽으로 이동 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (maxNum < tempState[i][j])
						maxNum = tempState[i][j];
					next = -1;

					for (int k = j + 1; k < N; k++) {
						if (tempState[i][k] != 0) {
							next = k;
							break;
						}
					}
					if (tempState[i][j] == 0 && next != -1) {
						tempState[i][j] = tempState[i][next];
						tempState[i][next] = 0;
						next = j + 1;
						for (int k = next; k < N; k++) {
							if (tempState[i][k] != 0) {
								next = k;
								break;
							}
						}
					}
					if (next != -1 && tempState[i][j] != 0 && tempState[i][j] == tempState[i][next]) {
						tempState[i][j] = tempState[i][j] * 2;
						if (maxNum < tempState[i][j])
							maxNum = tempState[i][j];
						tempState[i][next] = 0;
					}
				}
			}
			state.put(tempState, num+1);

			
			state.remove(newState);
			it = state.keySet().iterator();

		}

		System.out.println(maxNum);

	}
}
