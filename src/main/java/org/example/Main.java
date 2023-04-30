package org.example;

public class Main {
	public static void main(String[] args) {
		AlgorithmService algorithmService = new AlgorithmService();
		algorithmService.fillCriteriaMatrix(4);
		algorithmService.printMatrix();
	}
}