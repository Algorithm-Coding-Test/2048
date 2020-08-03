# 2048
## 2048 (Easy)
BAEKJOON ONLINE JUDGE
12100번 문제


#### 문제
[https://www.acmicpc.net/problem/12100](https://www.acmicpc.net/problem/12100)
#### 풀이
모든 경우의 수에 대해 *BFS* 알고리즘을 통해 5번 이동시켜 얻을 수 있는 최대 값을 찾는 문제를 해결했다.

보드는 `int[][]` 이중 배열로 나타냈으며, 보드의 상태는 `LinkedHashMap<int[][], Integer>` 로, 이동시킨 횟수와 보드를 `LinkedHashMap`으로 나타냈다.

초기 상태를 `LinkedHashMap<int[][], Integer> state`에 삽입한다.

Iterator를 통해 next가 있을 때까지 아래를 반복한다.

1. 보드를 나타내는 `newState`와 `num`을 꺼내 `num`이 5이면 반복문을 탈출한다.
2. 현재 보드에서 위, 아래, 오른쪽, 왼쪽 방향으로 각각 이동시킨다.
3. 이동 시킨 보드에서 얻은 최대값을 통해 `maxNum`을 갱신한다.
4. 이동 시킨 보드와 `num+1`을 가지는 새로운 `State` 를 각각 `state`에 삽입한다.
5. 현재 `State`를 `state`에서 삭제한다.

