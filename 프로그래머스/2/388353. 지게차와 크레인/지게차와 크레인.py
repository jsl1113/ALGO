from collections import deque

def solution(storage, requests):
    grid = [list('0' + row + '0') for row in storage]
    cols = len(grid[0])
    grid.insert(0, ['0'] * cols)
    grid.append(['0'] * cols)

    rows, cols = len(grid), len(grid[0])
    DIRS = [(0,1),(0,-1),(1,0),(-1,0)]

    def is_valid(r, c):
        return 0 <= r < rows and 0 <= c < cols

    def recalc_outside():
        for r in range(rows):
            for c in range(cols):
                if not grid[r][c].isalpha():
                    grid[r][c] = '1'

        queue = deque()
        for r in range(rows):
            for c in range(cols):
                if (r == 0 or r == rows-1 or c == 0 or c == cols-1):
                    grid[r][c] = '0'
                    queue.append((r, c))

        while queue:
            r, c = queue.popleft()
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if is_valid(nr, nc) and grid[nr][nc] == '1':
                    grid[nr][nc] = '0'
                    queue.append((nr, nc))

    def forklift(box):
        targets = [
            (r, c)
            for r in range(1, rows-1)
            for c in range(1, cols-1)
            if grid[r][c] == box
            and any(grid[r+dr][c+dc] == '0' for dr, dc in DIRS)
        ]
        for r, c in targets:
            grid[r][c] = '1' 
        recalc_outside()

    def crane(box):
        for r in range(1, rows-1):
            for c in range(1, cols-1):
                if grid[r][c] == box:
                    grid[r][c] = '1'
        recalc_outside()

    for req in requests:
        crane(req[0]) if len(req) == 2 else forklift(req[0])

    return sum(
        grid[r][c].isalpha()
        for r in range(1, rows-1)
        for c in range(1, cols-1)
    )