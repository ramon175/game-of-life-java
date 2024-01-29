# Conway's Game of Life

This is a simple version of the famous Conway's Game of Life, written in Java.
I did this project for the first time while I was in university, and though of adding it to my github now,
after revisiting it a couple of years later.

## Game Rules

The program will be responsible for generating the initial seed and generations. This can be configurable if preferred.

Every generation, a Cell will be checked against the following rules:

1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## Logic description

Every Cell will go through the process of checking all it's neighbors, by accessing the deltas (differences)
from the line and column of the current cell, to verify if the neighbor is alive or not.
```
// calculate the delta from current line (get previous line position)
int dx = x + i;
// calculate the delta from current column (get previous column position)
int dy = y + j;
//verify if delta positions are bigger than 0 (avoid edges) and if cell is alive
if(dx >= 0 && dx < SIZE && dy >= 0 && dy < SIZE && board[dx][dy]){
    count++;
}
```

## Result 

Results will be generated in a CSV, and also logged. A CSV with the initial seed is also created.