import sys

n = int(sys.stdin.readline())
def fibonacci(k):
    list = [1, 1]
    if k==1 or k==2:
        return 1
    for i in range(k-2):
        list[i%2] += list[(i+1)%2]
    return list[(k+1)%2]
for i in range(n):
    fib = int(sys.stdin.readline())
    if fib == 0:
        print("1 0")
    elif fib == 1:
        print("0 1")
    else:
        print(fibonacci(fib-1),end=' ')
        print(fibonacci(fib))
        