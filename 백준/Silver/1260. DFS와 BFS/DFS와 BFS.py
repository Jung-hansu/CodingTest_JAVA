from collections import deque

n, m, v = map(int, input().split())
adj = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

for i in range(1, n + 1):
    adj[i].sort()

def dfs(visited, cur):
    visited[cur] = True
    print(cur, end=" ")
    for next in adj[cur]:
        if not visited[next]:
            dfs(visited, next)

def bfs():
    q = deque()
    visited = [False for _ in range(n + 1)]

    q.append(v)
    visited[v] = True
    while len(q):
        cur = q.popleft()
        print(cur, end=" ")
        
        for next in adj[cur]:
            if not visited[next]:
                q.append(next)
                visited[next] = True

dfs([False for _ in range(n + 1)], v)
print()
bfs()