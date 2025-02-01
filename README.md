# Expression Calculator

A versatile calculator application that can evaluate **postfix**, **prefix**, and **infix** expressions. 
The app automatically detects the type of expression entered and computes the result accordingly. 
Built with simplicity and efficiency in mind, this tool is perfect for anyone learning about or working with different expression notations.

## Features

- **Automatic Expression Detection**: The app identifies whether the input is a postfix, prefix, or infix expression.
- **Support for Multiple Notations**:
  - **Infix**: Standard arithmetic notation (e.g., `3 + 4 * 2`).
  - **Postfix**: Reverse Polish Notation (e.g., `3 4 2 * +`).
  - **Prefix**: Polish Notation (e.g., `+ 3 * 4 2`).
- **Error Handling**: Provides clear error messages for invalid expressions.
- **User-Friendly Interface**: Simple and intuitive input/output interface.

## How It Works

1. **Input**: Enter your expression in the provided input field.
2. **Detection**: The app automatically detects the type of expression (postfix, prefix, or infix).
3. **Evaluation**: The expression is evaluated, and the result is displayed.
4. **Output**: The result is shown along with the type of expression detected.

## Examples

### Infix Expression
- Input: `3 + 4 * 2`
- Output: `Result: 11 (Infix)`
- `Postfix: 3 4 2 * +`

### Postfix Expression
- Input: `3 4 2 * +`
- Output: `Result: 11 (Postfix)`
- `Infix: ((4*2) + 3)`

### Prefix Expression
- Input: `+ 3 * 4 2`
- Output: `Result: 11 (Prefix)`
- `Infix: ((4*2) + 3)`

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Rock68ir/Calculator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Calculator
   ```
4. Run the application:
   Using Android studio

## Technologies Used

- **Programming Language**: [Java - xml]

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeatureName`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeatureName`).
5. Open a pull request.
