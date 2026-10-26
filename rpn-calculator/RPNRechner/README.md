# RPN Calculator

An interactive command-line calculator written in Java, using **Reverse Polish Notation (RPN)**.
Numbers are pushed onto a stack first — operators then act on the top elements.

Built with custom data structures: no Java Collections, no ArrayList. Everything from scratch.

## Project Structure

```
RPNRechner/
├── TaschenRechnerV42Adv.java  ← Main program & RPN logic
├── MyStack.java               ← Custom stack (dynamic double array)
└── MyList.java                ← Custom list (dynamic double array) — helper structure
```

## Compile & Run

```bash
# Inside RPNRechner/
javac *.java
java TaschenRechnerV42Adv
```

## Usage

The program runs in a REPL loop. Valid inputs:

| Input | Description |
|---|---|
| `<number>` | Push number onto stack (negatives supported) |
| `+` `-` `*` `/` | Basic arithmetic (requires 2 elements) |
| `sqrt` | Square root of top element |
| `inv` | Inverse (1/x) |
| `dup` | Duplicate top element |
| `drop` | Remove top element |
| `swap` | Swap top two elements |
| `fact` | Factorial (non-negative integers only) |
| `ln` | Natural logarithm |
| `yx` | y to the power of x (y = second, x = top) |
| `pi` | Push π onto stack |
| `clear` | Clear the stack |
| `exit` | Exit the program |

## MyStack — Methods

| Method | Description |
|---|---|
| `push(double x)` | Push value onto stack |
| `pop()` | Remove and return top element |
| `peek()` | Return top element without removing |
| `peek(int indexFromTop)` | Return element at position from top |
| `remove(int idx)` | Remove element at absolute index |
| `size()` | Return number of elements |
| `clear()` | Empty the stack |

## What I learned

- Building dynamic array structures without standard libraries forces you to understand memory management and resizing
- RPN requires clean stack discipline — good practice for thinking about execution order
- Edge case handling (division by zero, negative sqrt, invalid factorial) matters more than the happy path

## Bug fixes applied

- Negative numbers now correctly parsed as values, not unknown operators
- Division by zero caught and handled — stack left unchanged
- `sqrt`, `ln`, `inv`, `fact` validate input and preserve stack state on error
