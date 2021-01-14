import java.io.File;

public class Test {
//main method
	public static void main(String[] args) {
		Rational[][] A = {
				{new Rational("1/2"),new Rational("1/2"),new Rational("1/2")},
				{new Rational("1/2"),new Rational("1/2"),new Rational("1/2")},
				{new Rational("1/2"),new Rational("1/2"),new Rational("1/2")}
		};
		//Creating rational matrices
		GenericMatrix<Rational> rationalMatrix1 = new GenericMatrix<>(A);
		GenericMatrix<Rational> rationalMatrix2 = new GenericMatrix<>(A);
		GenericMatrix<Rational> rationalMatrix3;
		
		//Operations on rational matrices
		System.out.println("RationalMatrices");
		rationalMatrix3=rationalMatrix1.add(rationalMatrix2);
		System.out.println("Addition");
		printMatrixOperation(rationalMatrix1,rationalMatrix2,'+',rationalMatrix3);
		
		rationalMatrix3=rationalMatrix1.subtract(rationalMatrix2);
		System.out.println("Subtraction");
		printMatrixOperation(rationalMatrix1,rationalMatrix2,'-',rationalMatrix3);
		
		rationalMatrix3=rationalMatrix1.subtract(rationalMatrix2);
		System.out.println("Multiplication");
		printMatrixOperation(rationalMatrix1,rationalMatrix2,'*',rationalMatrix3);
		
		Complex[][]AC={
				{new Complex(1,2),new Complex(1,2),new Complex(1,2)},
				{new Complex(1,2),new Complex(1,2),new Complex(1,2)},
				{new Complex(1,2),new Complex(1,2),new Complex(1,2)}
		};
		//Creating complex matrices
		GenericMatrix<Complex>complexMatrix1=new GenericMatrix<>(AC);
		GenericMatrix<Complex>complexMatrix2=new GenericMatrix<>(AC);
		GenericMatrix<Complex>complexMatrix3;
		
		//Operations on complex matrices
		System.out.println("Complex Matrices");
		complexMatrix3=complexMatrix1.add(complexMatrix2);
		System.out.println("Addition");
		printMatrixOperation(complexMatrix1,complexMatrix2,'+',complexMatrix3);
		
		complexMatrix3=complexMatrix1.subtract(complexMatrix2);
		System.out.println("Subtraction");
		printMatrixOperation(complexMatrix1,complexMatrix2,'-',complexMatrix3);
		complexMatrix3=complexMatrix1.multiply(complexMatrix2);
		System.out.println("Multiplication");
		printMatrixOperation(complexMatrix1,complexMatrix2,'*',complexMatrix3);
	}
	
	//Generic method to print matrix operation result 
	public static<E extends Arithmetic<E>>
	void printMatrixOperation(GenericMatrix<E>m1, GenericMatrix<E>m2,char operation,
							  GenericMatrix<E>result){
		
		for(int i=0;i<m1.rows();i++) {
			System.out.print("|");
			for(int j=0;j<m1.columns();j++){
				System.out.print(m1.get(i,j).toString() + " ");
			}
		if(i!=m1.rows() / 2) {
		System.out.print("|   |" );
		}
		else {
			System.out.print("| " + operation + " |");
		}
		
			for(int j=0;j<m2.columns();j++) {
				System.out.print(m2.get(i,j).toString() + " ");
			}
			if(i!=m2.rows() / 2) {
				System.out.print("|   |" );
				}
				else {
					System.out.print("| " + "=" + " |");
				}
		
			for(int j=0;j<result.columns();j++) {
				System.out.print(result.get(i,j).toString() + " ");
			}
		
		System.out.println("|");

	}

	}
}
