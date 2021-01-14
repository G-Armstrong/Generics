import java.util.ArrayList;


public class GenericMatrix<E extends Arithmetic<E>>{
	private ArrayList<ArrayList<E>> matrix;
	
	/**
	 * Constructor that creates the array list matrix and makes a deep copy of the array input to matrix
	 * @param input 2D array to be copied
	 */
	public GenericMatrix(E[][] input) {
		matrix = new ArrayList<>(); //size = 0; capacity = 10, first dimension
		for(int i=0;i<input.length;i++) {
			ArrayList<E> row = new ArrayList<>();
			for(int j=0;j<input[i].length;j++) {
				row.add(input[i][j]);
			}
			matrix.add(row);
		}
			
	}
	/**
	 * Constructor that creates the array list matrix and makes a deep copy of the array list input to matrix
	 * @param input array list to be copied
	 */
	public GenericMatrix (ArrayList<ArrayList<E>> input) {
		matrix = new ArrayList<>(); //size = 0; capacity = 10, first dimension
		for(int i=0; i<input.size(); i++) {
			ArrayList<E> row = new ArrayList<>();
			for(int j=0; j<input.get(i).size(); j++) {
				row.add(input.get(i).get(j));
			}
			matrix.add(row);
		}
	}
	/**
	 * Getter method
	 * @param r rows
	 * @param c columns
	 * @return returns E at location r,c in matrix
	 */
	public E get(int r, int c) {	
		return matrix.get(r).get(c);
	}
	/**
	 * Setter method
	 * @param r rows
	 * @param c coulmns
	 * @param value
	 * @return returns the value after setting it at r,c
	 */
	public E set(int r, int c, E value) {
		return matrix.get(r).set(c, value);
	}
	/**
	 * Returns number of rows
	 */
	public int rows() {
		return matrix.size();
	}
	/**
	 * Returns number of columns
	 */
	public int columns() {
		return matrix.get(0).size();
	}
	/**
	 * Adds two matricies
	 * @param gm matrix B to be added to A to return C 
	 * @return matrix C
	 */
	public GenericMatrix<E> add(GenericMatrix<E> gm){
		GenericMatrix<E> temp = new GenericMatrix<>(matrix);
		for(int i=0; i<rows();i++) {
			for(int j=0;j<columns();j++) {
				temp.set(i, j, matrix.get(i).get(j).add(gm.matrix.get(i).get(j)));

			}
		}
		return temp;
	}
	/**
	 * Subtracts two matricies
	 * @param gm matrix B to be subtracted from A to return C 
	 * @return matrix C
	 */
	public GenericMatrix<E> subtract(GenericMatrix<E> gm){
		GenericMatrix<E> temp = new GenericMatrix<>(matrix);
		for(int i=0; i<rows();i++) {
			for(int j=0;j<columns();j++) {
				temp.set(i, j, matrix.get(i).get(j).subtract(gm.matrix.get(i).get(j)));

			}
		}
		return temp;
	}
	/**
	 * Adds two matricies
	 * @param gm matrix B to be multiplied by A to return C 
	 * @return matrix C
	 */
	public GenericMatrix<E> multiply(GenericMatrix<E> gm){
		GenericMatrix<E> temp = new GenericMatrix<>(matrix);
		for(int i=0; i<rows();i++) {
			for(int j=0;j<columns();j++) {
				for(int k=0;k<columns();k++) {
					if(k==0) {
						temp.set(i, j, matrix.get(i).get(j).multiply(gm.matrix.get(i).get(j)));
					}
					else {
						temp.set(i, j, temp.get(i, j).add(matrix.get(i).get(k).multiply(gm.matrix.get(k).get(j))));
					}
					
				}
			}
		}
		return temp;
	}

}
