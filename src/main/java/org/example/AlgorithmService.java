package org.example;

import java.util.*;

public class AlgorithmService {

	private Point[][] matrix;
	private List<Double> scale;

	public void fillCriteriaMatrix(int amountOfCriteria) {
		fillScale();

		matrix = new Point[amountOfCriteria][amountOfCriteria];
		for (int i = 0; i < amountOfCriteria; i++) {
			for (int j = 0; j < amountOfCriteria; j++) {
				matrix[i][j] = compareCriteria();
			}
		}
	}

	private Point compareCriteria() {
		int scaleIndex = getRandomIndex(scale);
		return Point.builder()
				.value(scale.get(scaleIndex))
				.build();
	}

	public static int getRandomIndex(List<Double> scale) {
		Random random = new Random();
		return random.nextInt(scale.size());
	}


	private void fillScale(){
		scale = new ArrayList<>();
		scale.add(0.111);
		scale.add(0.142);
		scale.add(0.2);
		scale.add(0.333);
		scale.add(1.0);
		scale.add(3.0);
		scale.add(5.0);
		scale.add(7.0);
		scale.add(9.0);
	}

	public void printMatrix() {
		for (Point[] row : matrix) {
			for (Point point : row) {
				System.out.print(point.getValue() + "\t");
			}
			System.out.println();
		}
	}

}